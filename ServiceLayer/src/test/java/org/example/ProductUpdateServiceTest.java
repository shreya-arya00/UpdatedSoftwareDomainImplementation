package org.example;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class ProductUpdateServiceTest {

    private ProductUpdateService productUpdateService;

    @Mock
    private ProductRepository productRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        productUpdateService = new ProductUpdateService(productRepository);
    }

    @Test
    public void testUpdateProduct_Success() {
        Product product = new Product("1", "Test Product", "Description", 10.0);
        Mockito.when(productRepository.findById("1")).thenReturn(product);
        productUpdateService.updateProduct(product);
        Mockito.verify(productRepository).update(product);
    }

    @Test(expected = ProductException.class)
    public void testUpdateProduct_NotFound() {
        Product product = new Product("2", "Test Product", "Description", 10.0);
        Mockito.when(productRepository.findById("2")).thenReturn(null);
        productUpdateService.updateProduct(product);
    }
}

