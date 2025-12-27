package org.example.fatsecret.Controllers;

import org.example.fatsecret.Entity.Product;
import org.example.fatsecret.Exceptions.NameEmptyException;
import org.example.fatsecret.Service.ProductService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/product")
public class ProductController {
    private final ProductService productService;
    public ProductController(ProductService productService){
        this.productService = productService;
    }
    @PostMapping("/catalog")
    public Product addProduct(@RequestBody Product product){
        if (product.getProductName().isEmpty()) {
            throw new NameEmptyException();
        }
        return productService.createProduct(product);
    }
    }

