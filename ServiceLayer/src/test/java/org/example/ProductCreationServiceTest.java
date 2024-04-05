package org.example;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class ProductCreationServiceTest {

    private ProductCreationService productCreationService;

    @Mock
    private ProductRepository productRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        productCreationService = new ProductCreationService(productRepository);
    }

    @Test
    public void testCreateProduct_Success() {
        Product product = new Product("1", "Test Product", "Description", 10.0);
        productCreationService.createProduct(product);
        Mockito.verify(productRepository).create(product);
    }

    @Test(expected = ProductException.class)
    public void testCreateProduct_NullId() {
        Product product = new Product(null, "Test Product", "Description", 10.0);
        productCreationService.createProduct(product);
    }

    @Test(expected = ProductException.class)
    public void testCreateProduct_EmptyId() {
        Product product = new Product("", "Test Product", "Description", 10.0);
        productCreationService.createProduct(product);
    }
}
