import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Repository layer implementation using HashMap
class InMemoryProductRepository implements ProductRepository {
    private Map<String, Product> products = new HashMap<>();

    @Override
    public void create(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public void update(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public void delete(String productId) {
        products.remove(productId);
    }

    @Override
    public Product findById(String productId) {
        return products.get(productId);
    }

    @Override
    public Collection<Product> findAll() {
        return products.values();
    }

    @Override
    public Collection<Product> findByField(String fieldName, String value) {
        List<Product> result = new ArrayList<>();
        for (Product product : products.values()) {
            switch (fieldName) {
                case "name":
                    if (product.getName().equals(value))
                        result.add(product);
                    break;
                // Add more cases for other fields if needed
            }
        }
        return result;
    }
}
