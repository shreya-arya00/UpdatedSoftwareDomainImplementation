// Custom exception for product-related errors
class ProductException extends RuntimeException {
    public ProductException(String message) {
        super(message);
    }
}
