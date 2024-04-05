package org.example;

class ProductUpdateService {
    private ProductRepository productRepository;

    public ProductUpdateService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void updateProduct(Product product) {
        if (productRepository.findById(product.getId()) == null) {
            throw new ProductException("Product not found with ID: " + product.getId());
        }
        productRepository.update(product);
    }
}
