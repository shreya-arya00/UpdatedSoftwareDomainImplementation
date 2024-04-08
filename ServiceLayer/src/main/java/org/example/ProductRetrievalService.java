package org.example;

class ProductRetrievalService {
    private ProductRepository productRepository;

    public ProductRetrievalService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product findProductById(String productId) {
        Product product = productRepository.findById(productId);
        if (product == null) {
            throw new ProductException("Product not found with ID: " + productId);
        }
        return product;
    }

    public Collection<Product> findAllProducts() {
        return productRepository.findAll();
    }
}
