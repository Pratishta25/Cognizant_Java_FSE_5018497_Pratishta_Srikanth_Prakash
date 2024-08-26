package com.bookstoreapi.controller;

import com.bookstoreapi.dto.BookDTO;
import com.bookstoreapi.mapper.BookMapper;
import com.bookstoreapi.model.Book;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookMapper bookMapper;
    private List<Book> books;

    public BookController(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
        this.books = List.of(
            new Book(1, "Effective Java", "Joshua Bloch", 45.00, "9780134685991"),
            new Book(2, "Clean Code", "Robert C. Martin", 40.00, "9780132350884")
        );
    }

    @GetMapping
    public List<BookDTO> getAllBooks() {
        return books.stream()
                    .map(bookMapper::toBookDTO)
                    .collect(Collectors.toList());
    }

    @PostMapping
    public BookDTO addBook(@RequestBody BookDTO bookDTO) {
        Book book = bookMapper.toBook(bookDTO);
        books.add(book);
        return bookMapper.toBookDTO(book);
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
