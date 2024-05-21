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

  getProductList(): Observable<Product[]> {

    const searchUrl = `${this.baseUrl}/products?size=10&page=0`;
    return this.getProducts(searchUrl)
  }


  getProductListByCategoryId(theCategoryId: number): Observable<Product[]> {

    const searchUrl = `${this.baseUrl}/products/category/${theCategoryId}`;
    return this.getProducts(searchUrl)
  }

  getProductCategories(): Observable<ProductCategory[]>  {
    const searchUrl = `${this.baseUrl}/products-category`
    return this.httpClient.get<GetProductsCategoriesResponse>(searchUrl).pipe(
      map(response => response.content)
    )
  }


  searchProducts(keyword: string): Observable<Product[]> {
    const searchUrl = `${this.baseUrl}/products/name-containing/${keyword}`
    return this.getProducts(searchUrl)
  }

  private getProducts(searchUrl: string): Observable<Product[]> {
    return this.httpClient.get<GetProductsResponse>(searchUrl).pipe(
      map(response => response.content)
    );
  }
}


interface GetProductsResponse {
  content: Product[]
}

interface GetProductsCategoriesResponse {
  content: ProductCategory[]
}
