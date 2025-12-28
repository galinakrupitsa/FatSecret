package org.example.fatsecret.Repositories;

import org.example.fatsecret.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Product getProductsById(Long id);
}
