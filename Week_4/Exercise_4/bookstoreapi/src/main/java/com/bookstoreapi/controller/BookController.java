package com.bookstoreapi.controller;

import com.bookstoreapi.model.Book;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    // Temporary in-memory book storage
    private List<Book> books = new ArrayList<>();

    // Fetch all books or filter by query parameters (title, author)
    @GetMapping
    public List<Book> getAllBooks(@RequestParam(required = false) String title,
                                  @RequestParam(required = false) String author) {
        if (title != null && author != null) {
            return books.stream()
                        .filter(book -> book.getTitle().equalsIgnoreCase(title) &&
                                        book.getAuthor().equalsIgnoreCase(author))
                        .toList();
        } else if (title != null) {
            return books.stream()
                        .filter(book -> book.getTitle().equalsIgnoreCase(title))
                        .toList();
        } else if (author != null) {
            return books.stream()
                        .filter(book -> book.getAuthor().equalsIgnoreCase(author))
                        .toList();
        }
        return books;
    }
    // Fetch a book by ID using a path variable
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable int id) {
        return books.stream()
                    .filter(book -> book.getId() == id)
                    .findFirst()
                    .orElse(null); // You could return a custom exception if the book isn't found
    }
    // POST request to add a new book
    @PostMapping
    public Book addBook(@RequestBody Book book) {
        books.add(book);
        return book;
    }

    // PUT request to update a book by id
    @PutMapping("/{id}")
    public Book updateBook(@PathVariable int id, @RequestBody Book updatedBook) {
        for (Book book : books) {
            if (book.getId() == id) {
                book.setTitle(updatedBook.getTitle());
                book.setAuthor(updatedBook.getAuthor());
                book.setPrice(updatedBook.getPrice());
                book.setIsbn(updatedBook.getIsbn());
                return book;
            }
        }
        return null; // or throw an exception
    }

    // DELETE request to remove a book by id
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable int id) {
        books.removeIf(book -> book.getId() == id);
    }
}