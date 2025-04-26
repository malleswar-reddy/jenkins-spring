package com.jenkins.service;


import com.jenkins.controller.ProductController;
import com.jenkins.model.Product;
import com.jenkins.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    // Mock the ProductRepository
    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    @Test
    public void testGetProductById() {
        // Arrange
        Long productId = 1L;
        // Create a mock Product object
        Product mockProduct = new Product();
        mockProduct.setId(productId);
        mockProduct.setName("Test Product");

        // Mock the repository call
        Mockito.when(productRepository.findById(productId)).thenReturn(Optional.of(mockProduct));
        // Act
        Product product = productService.getProductById(productId);
        // Assert
        assert product != null;
        assert product.getId().equals(productId);
        assert product.getName().equals("Test Product");
        // Verify the interaction with the repository
        Mockito.verify(productRepository, Mockito.times(1)).findById(productId);
        // Verify that no other interactions occurred
        Mockito.verifyNoMoreInteractions(productRepository);
        // Verify that the product was retrieved correctly
        assert product.getId().equals(productId);
        assert product.getName().equals("Test Product");
        // Verify that the product was saved correctly
       // Mockito.verify(productRepository, Mockito.times(1)).save(mockProduct);
    }

}
