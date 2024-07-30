import java.util.Arrays;
import java.util.Comparator;

public class LibraryManagementSystem {
    private Book[] books;
    private int size;

    public LibraryManagementSystem(Book[] books) {
        this.books = books;
        this.size = books.length;
        // Sort the books array by title
        Arrays.sort(this.books, Comparator.comparing(Book::getTitle));
    }

    // Binary Search
    public Book binarySearchByTitle(String title) {
        int left = 0;
        int right = size - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = books[mid].getTitle().compareToIgnoreCase(title);
            
            if (cmp == 0) {
                return books[mid];
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
