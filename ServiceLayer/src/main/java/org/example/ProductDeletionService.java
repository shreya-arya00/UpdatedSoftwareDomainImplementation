package org.example;

class ProductDeletionService {
    private ProductRepository productRepository;

    public ProductDeletionService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void deleteProduct(String productId) {
        Product existingProduct = productRepository.findById(productId);
        if (existingProduct == null) {
            throw new ProductException("Product not found with ID: " + productId);
        }
        productRepository.delete(productId);
    }
}

