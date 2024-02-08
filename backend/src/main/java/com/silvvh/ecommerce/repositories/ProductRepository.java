package com.silvvh.ecommerce.repositories;

import com.silvvh.ecommerce.domain.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
