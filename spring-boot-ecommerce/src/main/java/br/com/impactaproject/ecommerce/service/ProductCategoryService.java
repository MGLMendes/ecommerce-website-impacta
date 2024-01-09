package br.com.impactaproject.ecommerce.service;

import br.com.impactaproject.ecommerce.entities.ProductCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductCategoryService {
    Page<ProductCategory> getAllProductsCategory(Pageable pageable);

    ProductCategory getProductCateogoryById(Long id);

}
