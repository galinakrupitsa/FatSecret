package org.example.fatsecret.Repositories;

import org.example.fatsecret.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
