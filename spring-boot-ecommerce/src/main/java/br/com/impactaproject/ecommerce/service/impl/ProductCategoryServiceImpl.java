package br.com.impactaproject.ecommerce.service.impl;

import br.com.impactaproject.ecommerce.entities.ProductCategory;
import br.com.impactaproject.ecommerce.repositories.ProductCategoryRepository;
import br.com.impactaproject.ecommerce.service.ProductCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    private final ProductCategoryRepository productCategoryRepository;

    @Override
    public Page<ProductCategory> getAllProductsCategory(Pageable pageable) {
        return productCategoryRepository.findAll(pageable);
    }

    @Override
    public ProductCategory getProductCateogoryById(Long id) {
        var productCategory = productCategoryRepository.findById(id);

        if (productCategory.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return productCategory.get();
    }
}
