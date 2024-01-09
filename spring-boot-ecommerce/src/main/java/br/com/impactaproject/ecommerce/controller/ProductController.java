package br.com.impactaproject.ecommerce.controller;

import br.com.impactaproject.ecommerce.assemble.ProductAssemble;
import br.com.impactaproject.ecommerce.dto.ProductDTO;
import br.com.impactaproject.ecommerce.entities.Product;
import br.com.impactaproject.ecommerce.service.ProductService;
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
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    private final ProductAssemble productAssemble;

    @GetMapping
    public ResponseEntity<Page<ProductDTO>> getAllProducts(Pageable pageable) {
        Page<Product> allProductsPage = productService.getAllProducts(pageable);
        List<ProductDTO> collectionModel = productAssemble.toCollectionModel(allProductsPage.getContent());
        return ResponseEntity.ok(new PageImpl<>(collectionModel, pageable, allProductsPage.getTotalElements()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id) {
        ProductDTO model = productAssemble.toModel(productService.getProductById(id));
        return ResponseEntity.ok(model);
    }
}
