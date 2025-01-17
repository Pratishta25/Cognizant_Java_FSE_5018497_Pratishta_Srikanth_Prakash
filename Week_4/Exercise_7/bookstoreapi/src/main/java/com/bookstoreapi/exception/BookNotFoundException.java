package com.bookstoreapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)  // 404 Not Found
public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(int id) {
        super("Book with ID " + id + " not found.");
    }
}
