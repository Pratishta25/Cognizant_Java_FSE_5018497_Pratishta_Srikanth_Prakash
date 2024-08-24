package com.bookstoreapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {

    private int id;

    @JsonProperty("book_title")
    private String title;

    private String author;

    @JsonProperty("price_in_usd")
    private double price;

    private String isbn;

    // Getters and Setters
}