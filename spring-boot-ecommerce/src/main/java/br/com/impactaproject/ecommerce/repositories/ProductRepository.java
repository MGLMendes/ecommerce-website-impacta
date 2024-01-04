package br.com.impactaproject.ecommerce.repositories;

import br.com.impactaproject.ecommerce.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface ProductRepository extends JpaRepository<Product, Long> {
}
