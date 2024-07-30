import java.util.HashMap;

public class InventoryManagementSystem {
    private HashMap<String, Product> inventory = new HashMap<>();

    // Add Product
    public void addProduct(Product product) {
        inventory.put(product.getProductId(), product);
    }

    // Update Product
    public void updateProduct(String productId, Product updatedProduct) {
        if (inventory.containsKey(productId)) {
            inventory.put(productId, updatedProduct);
        } else {
            System.out.println("Product not found.");
        }
    }

    // Delete Product
    public void deleteProduct(String productId) {
        inventory.remove(productId);
    }

    // Get Product
    public Product getProduct(String productId) {
        return inventory.get(productId);
    }
}
