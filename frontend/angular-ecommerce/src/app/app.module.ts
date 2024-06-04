import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http'

import { AppComponent } from './app.component';
import { ProductListComponent } from './components/product-list/product-list.component';
import { ProductService } from './services/product.service';
import { LoginComponent } from './components/login/login.component';

import { Routes, RouterModule } from '@angular/router';
import { ProductCategoryMenuComponent } from './components/product-category-menu/product-category-menu.component';
import { SearchComponent } from './components/search/search.component';
import { CartStatusComponent } from './components/cart-status/cart-status.component';
import { CartDetailsComponent } from './components/cart-details/cart-details.component';
import { CheckoutComponent } from './components/checkout/checkout.component';
import {  FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RegisterComponent } from './components/register/register.component';


const routes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: 'register', component: RegisterComponent},
  {path: 'checkout', component: CheckoutComponent},
  {path: 'cart-details', component: CartDetailsComponent},
  {path: 'search/:keyword', component: ProductListComponent},
  {path: 'category/:id', component: ProductListComponent},
  {path: 'category', component: ProductListComponent},
  {path: 'products', component: ProductListComponent},
  {path: '',redirectTo: '/login', pathMatch: 'full'},
  {path: '**',redirectTo: '/login', pathMatch: 'full'},

];
@NgModule({
  declarations: [
    AppComponent,
    ProductListComponent,
    ProductCategoryMenuComponent,
    SearchComponent,
    CartStatusComponent,
    CartDetailsComponent,
    CheckoutComponent,
    LoginComponent,
    RegisterComponent,
  ],
  imports: [
    RouterModule.forRoot(routes),
    BrowserModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [ProductService],
  bootstrap: [AppComponent]
})
export class AppModule { }
