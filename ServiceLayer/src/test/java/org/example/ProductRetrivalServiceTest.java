package org.example;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import java.util.Arrays;
import java.util.Collection;

public class ProductRetrievalServiceTest {

    private ProductRetrievalService productRetrievalService;

    @Mock
    private ProductRepository productRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        productRetrievalService = new ProductRetrievalService(productRepository);
    }

    @Test
    public void testFindProductById_Success() {
        String productId = "1";
        Product existingProduct = new Product(productId, "Test Product", "Description", 10.0);
        Mockito.when(productRepository.findById(productId)).thenReturn(existingProduct);

        Product foundProduct = productRetrievalService.findProductById(productId);

        assertEquals(existingProduct, foundProduct);
    }

    @Test(expected = ProductException.class)
    public void testFindProductById_NotFound() {
        String productId = "2";
        Mockito.when(productRepository.findById(productId)).thenReturn(null);

        productRetrievalService.findProductById(productId);
    }

    @Test
    public void testFindAllProducts_Success() {
        Product product1 = new Product("1", "Test Product 1", "Description 1", 10.0);
        Product product2 = new Product("2", "Test Product 2", "Description 2", 20.0);
        Mockito.when(productRepository.findAll()).thenReturn(Arrays.asList(product1, product2));

        Collection<Product> allProducts = productRetrievalService.findAllProducts();

        assertEquals(2, allProducts.size());
        assertTrue(allProducts.contains(product1));
        assertTrue(allProducts.contains(product2));
    }
}
