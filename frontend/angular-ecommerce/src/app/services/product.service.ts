import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, map } from 'rxjs';
import { Product } from '../common/product';
import { ProductCategory } from '../common/product-category';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private baseUrl = "http://localhost:8080/api"

  constructor(private httpClient: HttpClient) { }


  getProductList(theCategoryId: number): Observable<Product[]> {

    const searchUrl = `${this.baseUrl}/products/category/${theCategoryId}`;
    console.log("Search URL: ", searchUrl)
      return this.httpClient.get<GetProductsResponse>(searchUrl).pipe(
        map(response => response.content)
      )
  }

  getProductCategories(): Observable<ProductCategory[]>  {
    const searchUrl = `${this.baseUrl}/products-category`
    return this.httpClient.get<GetProductsCategoriesResponse>(searchUrl).pipe(
      map(response => response.content)
    )
  }
}


interface GetProductsResponse {
  content: Product[]
}

interface GetProductsCategoriesResponse {
  content: ProductCategory[]
}
