package com.example.wplabs2.service.book;

import com.example.wplabs2.entity.AuthorEntity;
import com.example.wplabs2.entity.BookEntity;

import java.util.List;

public interface BookService {

    List<BookEntity> findAll();

    BookEntity findByIsbn(String isbn) throws Exception;

    AuthorEntity addAuthorToBook(Long authorId, String isbn) throws Exception;

    BookEntity findById(Long id) throws Exception;

    void addBook(String isbn, String title, String genre, int year, Long bookStoreId) throws Exception;

    void editBook(Long id,String isbn, String title, String genre, int year, Long bookStoreId) throws Exception;

    void deleteBook(Long id);

}
