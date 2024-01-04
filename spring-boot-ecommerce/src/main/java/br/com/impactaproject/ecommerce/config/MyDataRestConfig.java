package br.com.impactaproject.ecommerce.config;

import br.com.impactaproject.ecommerce.entities.Product;
import br.com.impactaproject.ecommerce.entities.ProductCategory;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        HttpMethod[] thUnsupportedActions = {HttpMethod.DELETE, HttpMethod.PUT, HttpMethod.POST};

        config.getExposureConfiguration()
                .forDomainType(Product.class)
                .withItemExposure((metdate, httpMethods) -> httpMethods.disable(thUnsupportedActions))
                .withCollectionExposure((metdate, httpMethods) -> httpMethods.disable(thUnsupportedActions));

        config.getExposureConfiguration()
                .forDomainType(ProductCategory.class)
                .withItemExposure((metdate, httpMethods) -> httpMethods.disable(thUnsupportedActions))
                .withCollectionExposure((metdate, httpMethods) -> httpMethods.disable(thUnsupportedActions));
    }
}
