import java.util.Collection;

// Repository layer interface for Product CRUD operations
interface ProductRepository {
    void create(Product product);
    void update(Product product);
    void delete(String productId);
    Product findById(String productId);
    Collection<Product> findAll();
    Collection<Product> findByField(String fieldName, String value);
}
