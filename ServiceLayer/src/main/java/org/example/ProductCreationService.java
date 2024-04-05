package org.example;

class ProductCreationService {
    private ProductRepository productRepository;

    public ProductCreationService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void createProduct(Product product) {
        if (product.getId() == null || product.getId().isEmpty()) {
            throw new ProductException("Product ID cannot be null or empty.");
        }
        productRepository.create(product);
    }
}

