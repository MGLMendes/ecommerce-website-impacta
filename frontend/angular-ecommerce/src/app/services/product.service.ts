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
    
    // @TODO: need to build URL based on category id ... will come back to this!
    const searchUrl = `${this.baseUrl}/search/findByCategoryId?id=${theCategoryId}`;

      return this.httpClient.get<GetResponse>(this.baseUrl).pipe(
        map(response => response.content)
      )
  }
}


interface GetResponse {
  content: Product[]
}
