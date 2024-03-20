package br.com.impactaproject.ecommerce.service;

import br.com.impactaproject.ecommerce.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {

    Page<Product> getAllProducts(Pageable pageable);
    Page<Product> getAllProductsByCategoryId(Long id, Pageable pageable);

    Product getProductById(Long id);
}
