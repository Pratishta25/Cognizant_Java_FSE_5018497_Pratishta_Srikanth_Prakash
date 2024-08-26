package com.bookstoreapi.controller;

import com.bookstoreapi.model.Book;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private List<Book> books = new ArrayList<>();

    // GET request to retrieve all books
    @GetMapping
    @ResponseStatus(HttpStatus.OK)  // 200 OK
    public List<Book> getAllBooks() {
        return books;
    }

    // GET request to retrieve a book by ID
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)  // 200 OK
    public Book getBookById(@PathVariable int id) {
        return books.stream()
                    .filter(book -> book.getId() == id)
                    .findFirst()
                    .orElseThrow(() -> new BookNotFoundException(id));  // 404 Not Found if book isn't found
    }

    // POST request to add a new book
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)  // 201 Created
    public Book addBook(@RequestBody Book book) {
        books.add(book);
        return book;
    }

    // DELETE request to delete a book by ID
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)  // 204 No Content
    public void deleteBook(@PathVariable int id) {
        books.removeIf(book -> book.getId() == id);
    }
}

@ResponseStatus(HttpStatus.NOT_FOUND)  // 404 Not Found
class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(int id) {
        super("Book with ID " + id + " not found.");
    }
}
