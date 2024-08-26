package com.bookstoreapi.mapper;

import com.bookstoreapi.dto.BookDTO;
import com.bookstoreapi.model.Book;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookMapper {
    BookDTO toBookDTO(Book book);
    Book toBook(BookDTO bookDTO);
}
