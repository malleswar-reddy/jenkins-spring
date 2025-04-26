package com.jenkins.controller;

import com.jenkins.model.Product;
import com.jenkins.service.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class ProductControllerTest {

    @InjectMocks
    private ProductController productController;

    @Mock
    private ProductService productService;

    @Test
    void testGetProductById() {
        // Arrange
        Long productId = 1L;
        Product mockProduct = new Product();
        mockProduct.setId(productId);
        mockProduct.setName("Test Product");

        Mockito.when(productService.getProductById(productId)).thenReturn(mockProduct);

        // Act
        ResponseEntity<Product> response = productController.getProductById(productId);

        // Assert
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(productId, response.getBody().getId());
        assertEquals("Test Product", response.getBody().getName());

        // Verify
        Mockito.verify(productService, Mockito.times(1)).getProductById(productId);
    }
}