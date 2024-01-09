package br.com.impactaproject.ecommerce.controller;

import br.com.impactaproject.ecommerce.assemble.ProductCategoryAssemble;
import br.com.impactaproject.ecommerce.dto.ProductCategoryDTO;
import br.com.impactaproject.ecommerce.entities.ProductCategory;
import br.com.impactaproject.ecommerce.service.ProductCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/productsCategory")
@RequiredArgsConstructor
public class ProductCategoryController {

    private final ProductCategoryService productCategoryService;

    private final ProductCategoryAssemble productCategoryAssemble;

    @GetMapping
    public ResponseEntity<Page<ProductCategoryDTO>> getAllProducts(Pageable pageable) {
        Page<ProductCategory> allProductsCategory = productCategoryService.getAllProductsCategory(pageable);
        List<ProductCategoryDTO> collectionModel = productCategoryAssemble.toCollectionModel(allProductsCategory.getContent());
        return ResponseEntity.ok(new PageImpl<>(collectionModel, pageable, allProductsCategory.getTotalElements()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductCategoryDTO> getProductById(@PathVariable Long id) {
        return ResponseEntity.ok(productCategoryAssemble.toModel(productCategoryService.getProductCateogoryById(id)));
    }
}
