// Main class to run the program
public class OnlineShoppingSystem {

    public static void main(String[] args) {
        // Initialize repository
        ProductRepository productRepository = new InMemoryProductRepository();

        // Initialize service
        ProductService productService = new ProductService(productRepository);

        try {
            // Create products
            Product product1 = new Product("1", "Product 1", "Description for Product 1", 19.99);
            Product product2 = new Product("2", "Product 2", "Description for Product 2", 29.99);

            // Add products to repository
            productService.createProduct(product1);
            productService.createProduct(product2);

            // Find product by ID
            Product foundProduct = productService.findProductById("1");
            System.out.println("Found Product by ID: " + foundProduct.getName());

            // Find products by name
            Collection<Product> productsByName = productService.findProductsByName("Product 2");
            System.out.println("Found Products by Name:");
            for (Product product : productsByName) {
                System.out.println(product.getName());
            }

            // Update product
            product2.setPrice(39.99);
            productService.updateProduct(product2);
            System.out.println("Updated Product Price: " + product2.getPrice());

            // Delete product
            productService.deleteProduct("1");
            System.out.println("Product Deleted.");

            // View all products
            Collection<Product> allProducts = productService.findAllProducts();
            System.out.println("All Products:");
            for (Product product : allProducts) {
                System.out.println(product.getName());
            }
        } catch (ProductException e) {
            System.err.println("Error occurred: " + e.getMessage());
        }
    }
}
