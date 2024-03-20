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
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
@CrossOrigin(maxAge = 20)
public class ProductController {

    private final ProductService productService;

    private final ProductAssemble productAssemble;

    @PreAuthorize("hasAnyRole('MEMBER')")
    @GetMapping
    public ResponseEntity<Page<ProductDTO>> getAllProducts(Pageable pageable) {
        Page<Product> allProductsPage = productService.getAllProducts(pageable);
        List<ProductDTO> collectionModel = productAssemble.toCollectionModel(allProductsPage.getContent());
        return ResponseEntity.ok(new PageImpl<>(collectionModel, pageable, allProductsPage.getTotalElements()));
    }


    @PreAuthorize("hasAnyRole('REGULAR')")
    @GetMapping("/category/{id}")
    public ResponseEntity<Page<ProductDTO>> getAllProductsByCategoryId(@PathVariable Long id, Pageable pageable) {
        Page<Product> allProductsPage = productService.getAllProductsByCategoryId(id, pageable);
        List<ProductDTO> collectionModel = productAssemble.toCollectionModel(allProductsPage.getContent());
        return ResponseEntity.ok(new PageImpl<>(collectionModel, pageable, allProductsPage.getTotalElements()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id) {
        ProductDTO model = productAssemble.toModel(productService.getProductById(id));
        return ResponseEntity.ok(model);
    }
}
