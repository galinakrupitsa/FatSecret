package org.example.fatsecret.Service;

import org.example.fatsecret.Entity.Product;
import org.example.fatsecret.Repositories.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private final ProductRepository productRepo;
    public ProductService(ProductRepository productRepo) {
        this.productRepo = productRepo;
    }
    public Product createProduct(Product product) {
        return productRepo.save(product);
    }
}
