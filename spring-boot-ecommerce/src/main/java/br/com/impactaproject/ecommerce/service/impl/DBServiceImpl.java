package br.com.impactaproject.ecommerce.service.impl;

import br.com.impactaproject.ecommerce.entities.Product;
import br.com.impactaproject.ecommerce.entities.ProductCategory;
import br.com.impactaproject.ecommerce.entities.Profile;
import br.com.impactaproject.ecommerce.entities.User;
import br.com.impactaproject.ecommerce.repositories.ProductCategoryRepository;
import br.com.impactaproject.ecommerce.repositories.ProductRepository;
import br.com.impactaproject.ecommerce.service.DBService;
import br.com.impactaproject.ecommerce.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Slf4j
public class DBServiceImpl implements DBService {

    @Value("${spring.profiles.active}")
    private String profileActive;

    private final ProductRepository productRepository;

    private final ProductCategoryRepository productCategoryRepository;

    private final UserService userService;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void instanciaDB() {
        if (profileActive != null && profileActive.equalsIgnoreCase("pre")) {
            log.info("Instanciando DB PRE");
            var cat1 = ProductCategory.builder()
                    .categoryName("Livros")
                    .build();

            var cat2 = ProductCategory.builder()
                    .categoryName("Jogos")
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


            User user = User.builder()
                    .name("Miguel")
                    .email("miguel@email.com")
                    .password(bCryptPasswordEncoder.encode("1234"))
                    .build();

            user.setProfile(Set.of(Profile.REGULAR, Profile.MEMBER));
            User user2 = User.builder()
                    .name("Gustavo")
                    .email("gustavo@email.com")
                    .password(bCryptPasswordEncoder.encode("1234"))
                    .build();
            user2.setProfile(Set.of(Profile.REGULAR));
            userService.saveUser(user);
            userService.saveUser(user2);
        } else {
            log.info("Instanciando DB PRO");
        }
    }
}
