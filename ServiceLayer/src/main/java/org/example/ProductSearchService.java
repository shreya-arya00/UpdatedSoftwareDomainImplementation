package org.example;

class ProductSearchService {
    private ProductRepository productRepository;

    public ProductSearchService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Collection<Product> findProductsByName(String name) {
        return productRepository.findByField("name", name);
    }
}
