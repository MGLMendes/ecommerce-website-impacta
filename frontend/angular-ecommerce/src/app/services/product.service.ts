import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, map } from 'rxjs';
import { Product } from '../common/product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private baseUrl = "http://localhost:8080/api/products"

  constructor(private httpClient: HttpClient) { }


  getProductList(theCategoryId: number): Observable<Product[]> {

    const searchUrl = `${this.baseUrl}/category/${theCategoryId}`;
    console.log("Search URL: ", searchUrl)
      return this.httpClient.get<GetResponse>(searchUrl).pipe(
        map(response => response.content)
      )
  }
}


interface GetResponse {
  content: Product[]
}
