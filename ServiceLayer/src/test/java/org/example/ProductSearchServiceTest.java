package org.example;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import java.util.Arrays;
import java.util.Collection;

public class ProductSearchServiceTest {

    private ProductSearchService productSearchService;

    @Mock
    private ProductRepository productRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        productSearchService = new ProductSearchService(productRepository);
    }

    @Test
    public void testFindProductsByName_Success() {
        String productName = "Test Product";
        Product product1 = new Product("1", productName, "Description 1", 10.0);
        Product product2 = new Product("2", productName, "Description 2", 20.0);
        Mockito.when(productRepository.findByField("name", productName)).thenReturn(Arrays.asList(product1, product2));

        Collection<Product> foundProducts = productSearchService.findProductsByName(productName);

        assertEquals(2, foundProducts.size());
        assertTrue(foundProducts.contains(product1));
        assertTrue(foundProducts.contains(product2));
    }
}
