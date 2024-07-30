import java.util.Arrays;
import java.util.Comparator;

public class SearchFunctions {
    // Binary Search
    public static Product binarySearch(Product[] products, String productId) {
        Arrays.sort(products, Comparator.comparing(Product::getProductId));
        int left = 0;
        int right = products.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = products[mid].getProductId().compareTo(productId);
            
            if (cmp == 0) {
                return products[mid];
            }
            if (cmp < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }
}
