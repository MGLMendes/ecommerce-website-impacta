package br.com.impactaproject.ecommerce.config;

import br.com.impactaproject.ecommerce.service.DBService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class DataBaseConfig {

    private final DBService dbService;

    @Bean
    public void instanciaDB() {
        dbService.instanciaDB();
    }
}
