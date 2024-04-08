package org.example;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class ProductDeletionServiceTest {

    private ProductDeletionService productDeletionService;

    @Mock
    private ProductRepository productRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        productDeletionService = new ProductDeletionService(productRepository);
    }

    @Test
    public void testDeleteProduct_Success() {
        String productId = "1";
        Product existingProduct = new Product(productId, "Test Product", "Description", 10.0);
        Mockito.when(productRepository.findById(productId)).thenReturn(existingProduct);

        productDeletionService.deleteProduct(productId);

        Mockito.verify(productRepository).delete(productId);
    }

    @Test(expected = ProductException.class)
    public void testDeleteProduct_NotFound() {
        String productId = "2";
        Mockito.when(productRepository.findById(productId)).thenReturn(null);

        productDeletionService.deleteProduct(productId);
    }
}
