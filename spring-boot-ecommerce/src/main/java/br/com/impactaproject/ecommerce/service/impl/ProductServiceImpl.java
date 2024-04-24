package br.com.impactaproject.ecommerce.service.impl;

import br.com.impactaproject.ecommerce.entities.Product;
import br.com.impactaproject.ecommerce.repositories.ProductRepository;
import br.com.impactaproject.ecommerce.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Page<Product> getAllProducts(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Page<Product> getAllProductsByCategoryId(Long id, Pageable pageable) {
        return productRepository.findByCategoryId(id, pageable);
    }

    @Override
    public Page<Product> getProductsByName(String name, Pageable pageable) {
        return productRepository.findByNameContaining(name, pageable);
    }

    @Override
    public Product getProductById(Long id) {
        var product = productRepository.findById(id);

        if (product.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return product.get();
    }

}
