import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Purchase } from '../common/purchase';
import { Observable } from 'rxjs';
import { LoginService } from './login.service';

@Injectable({
  providedIn: 'root'
})
export class CheckoutService {

  private purchaseUrl = "http://localhost:8080/api/checkout/purchase"

  constructor(
    private httpClient: HttpClient,
    private loginService: LoginService
  ) { }

  placeOrder(purchase: Purchase): Observable<any> {
    let token = this.loginService.getAuthHeader();
    console.log("TOKEN", token)
    return this.httpClient.post<Purchase>(this.purchaseUrl, purchase, token);
  }
}
