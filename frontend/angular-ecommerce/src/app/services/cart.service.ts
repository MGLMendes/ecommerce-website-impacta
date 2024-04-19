import { Injectable } from '@angular/core';
import { CartItem } from '../common/cart-item';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class CartService {

  cartItens: CartItem[] = [];

  totalPrice: Subject<number> = new Subject<number>;
  totalQuantity: Subject<number> = new Subject<number>;

  constructor() { }

  addToCart(cartItem: CartItem) {
    let alreadyExistInCart: boolean = false;
    let existingCartItem: CartItem = undefined;

    if (this.cartItens.length > 0) {
      existingCartItem = this.cartItens.find(tempCartItem => tempCartItem.id === cartItem.id)
      
      alreadyExistInCart = (existingCartItem != undefined);
    }

    if (alreadyExistInCart) {
      existingCartItem.quantity++;
    } else {
      this.cartItens.push(cartItem);
    }

    this.computeCartTotals();

  }

  computeCartTotals() {
    let totalPriceValue: number = 0;
    let totalQuantityValue: number = 0;

    for (let curranteCartItem of this.cartItens) {
      totalPriceValue += curranteCartItem.quantity * curranteCartItem.unitPrice;
      totalQuantityValue += curranteCartItem.quantity;
    }

    this.totalPrice.next(totalPriceValue);
    this.totalQuantity.next(totalQuantityValue);
  }
}
