package br.com.impactaproject.ecommerce.service.impl;

import br.com.impactaproject.ecommerce.entities.Product;
import br.com.impactaproject.ecommerce.entities.ProductCategory;
import br.com.impactaproject.ecommerce.repositories.ProductCategoryRepository;
import br.com.impactaproject.ecommerce.repositories.ProductRepository;
import br.com.impactaproject.ecommerce.service.DBService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class DBServiceImpl implements DBService {

    @Value("${spring.profiles.active}")
    private String profileActive;

    private final ProductRepository productRepository;

    private final ProductCategoryRepository productCategoryRepository;

    @Override
    public void instanciaDB() {
        if (profileActive != null && profileActive.equalsIgnoreCase("pre")) {
            log.info("Instanciando DB PRE");
            var cat1 = ProductCategory.builder()
                    .categoryName("BOOKS")
                    .build();

            var cat2 = ProductCategory.builder()
                    .categoryName("GAMES")
                    .build();

            productCategoryRepository.saveAll(List.of(cat1, cat2));


            var prod1 = Product.builder()
                    .sku("1231321312")
                    .name("The Last Of US - Part II")
                    .description("Elie vs Abby")
                    .unitsInStock(2)
                    .unitPrice(new BigDecimal(250))
                    .imageUrl("assets/images/products/thelastofus2.png")
                    .active(true)
                    .category(cat2)
                    .build();

            var prod2 = Product.builder()
                    .sku("1231321312")
                    .name("Pequeno Principe")
                    .description("Um principe pequeno")
                    .unitsInStock(4)
                    .unitPrice(new BigDecimal(26))
                    .imageUrl("assets/images/products/opequenoprincipe.jpeg")
                    .active(true)
                    .category(cat1)
                    .build();

            productRepository.saveAll(List.of(prod1, prod2));
        } else {
            log.info("Instanciando DB PRO");
        }
    }
}
