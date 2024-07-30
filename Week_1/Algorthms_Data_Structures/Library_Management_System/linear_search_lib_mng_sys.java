public class LibraryManagementSystem {
    private Book[] books;
    private int size;

    public LibraryManagementSystem(Book[] books) {
        this.books = books;
        this.size = books.length;
    }

    // Linear Search
    public Book linearSearchByTitle(String title) {
        for (int i = 0; i < size; i++) {
            if (books[i].getTitle().equalsIgnoreCase(title)) {
                return books[i];
            }
        }
        return null;
    }
}
