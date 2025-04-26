package com.jenkins.service;

import com.jenkins.model.Product;
import com.jenkins.repository.ProductRepository;
import org.springframework.stereotype.Service;

// ProductService.java
@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }
}
