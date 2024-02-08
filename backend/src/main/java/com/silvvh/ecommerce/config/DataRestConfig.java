package com.silvvh.ecommerce.config;

import com.silvvh.ecommerce.domain.category.ProductCategory;
import com.silvvh.ecommerce.domain.product.Product;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class DataRestConfig implements RepositoryRestConfigurer {
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        RepositoryRestConfigurer.super.configureRepositoryRestConfiguration(config, cors);
        HttpMethod[] unsupportedActions = {HttpMethod.PUT, HttpMethod.POST, HttpMethod.DELETE};

        // Disable PUT, POST and DELETE for Product
        config.getExposureConfiguration().forDomainType(Product.class).
                withItemExposure(((metdata, httpMethods) -> httpMethods.disable(unsupportedActions))).
                withCollectionExposure(((metdata, httpMethods) -> httpMethods.disable((unsupportedActions))));

        // Disable PUT, POST and DELETE for ProductCategory
         config.getExposureConfiguration().forDomainType(ProductCategory.class).
                withItemExposure(((metdata, httpMethods) -> httpMethods.disable(unsupportedActions))).
                withCollectionExposure(((metdata, httpMethods) -> httpMethods.disable((unsupportedActions))));
}
}
