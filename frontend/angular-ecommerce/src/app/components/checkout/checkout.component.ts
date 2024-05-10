import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { Order } from 'src/app/common/order';
import { OrderItem } from 'src/app/common/order-item';
import { Purchase } from 'src/app/common/purchase';
import { CartService } from 'src/app/services/cart.service';
import { CheckoutService } from 'src/app/services/checkout.service';
import { ImpactaFormService } from 'src/app/services/impacta-form.service';

@Component({
  selector: 'app-checkout',
  templateUrl: './checkout.component.html',
  styleUrls: ['./checkout.component.css']
})
export class CheckoutComponent implements OnInit {


  checkoutFormGroup: FormGroup;

  totalPrice: number = 0;
  totalQuantity: number = 0;


  creditCardMonths: number[] = [];
  creditCardYears: number[] = [];


  constructor(private formBuilder: FormBuilder,
    private impactService: ImpactaFormService,
    private cartService: CartService,
    private checkoutService: CheckoutService,
    private router: Router
  ) { }

  ngOnInit(): void {

    this.reviewCartDetails()

    this.checkoutFormGroup = this.formBuilder.group({
        customer: this.formBuilder.group({
          firstName: [''],
          lastName: [''],
          email: ['']
        }),
        shippingAddress: this.formBuilder.group({
          street: [''],
          city: [''],
          state: [''],
          country: [''],
          zipCode: ['']
        }),
        billingAddress: this.formBuilder.group({
          street: [''],
          city: [''],
          state: [''],
          country: [''],
          zipCode: ['']
        }),
        creditCard: this.formBuilder.group({
          cardType: [''],
          nameOnCard: [''],
          cardNumber: [''],
          securityCode: [''],
          expirationMonth: [''],
          expirationYear: ['']
        }),
    });

    const startMonth: number = new Date().getMonth() + 1;

    this.impactService.getCreditCardMonths(startMonth).subscribe(
      data => {
        console.log("Expiration Months: ", JSON.stringify(data))
        this.creditCardMonths = data;
      }
    )


    this.impactService.getCreditCardYears().subscribe(
      data => {
        console.log("Expiration Years: " , JSON.stringify(data))
        this.creditCardYears = data;
      }
    )
  }


  reviewCartDetails() {
    this.cartService.totalQuantity.subscribe(
      totalQuantity => {
        this.totalQuantity = totalQuantity;
      }
    );


    this.cartService.totalPrice.subscribe(
      totalPrice => {
        this.totalPrice = totalPrice;
      }
    );
  }


  onSubmit() {
    let order = new Order();
    order.totalPrice = this.totalPrice;
    order.totalQuantity = this.totalQuantity;


    const cartItems = this.cartService.cartItems;

    let orderItemsShort: OrderItem[] = cartItems.map(
      tempCartItem => new OrderItem(tempCartItem)
    );

    let purchase = new Purchase();

    purchase.customer = this.checkoutFormGroup.get('customer').value;

    purchase.shippingAddress = this.checkoutFormGroup.get('shippingAddress').value;
    purchase.billingAddress = this.checkoutFormGroup.get('billingAddress').value;

    purchase.order = order;
    purchase.orderItems = orderItemsShort;

    this.checkoutService.placeOrder(purchase).subscribe(
      {
        next: response => {
          console.log(response)
          alert(`Your order has been received.\n Order tracking number: ${response.orderTrackingNumber}`)
          this.resetCart()
        },
        error: error => {
          alert(`There was an error: ${error.message}`)
        }
      }
    )
  }

  resetCart() {
    this.cartService.cartItems = [];
    this.cartService.totalPrice.next(0);
    this.cartService.totalQuantity.next(0);

    this.checkoutFormGroup.reset();

    this.router.navigateByUrl("/products")
  }

  copyShippingAddressToBillingAddress(event) {
      if (event.target.checked) {
        this.checkoutFormGroup.get("billingAddress")
        .setValue(this.checkoutFormGroup.get("shippingAddress").value);
      } else {
        this.checkoutFormGroup.get('billingAddress').reset();
      }
  }

}
