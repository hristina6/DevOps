package com.example.wplabs2.data;

import com.example.wplabs2.entity.AuthorEntity;
import com.example.wplabs2.entity.AuthorFullName;
import com.example.wplabs2.entity.BookEntity;
import com.example.wplabs2.entity.BookStoreEntity;
import com.example.wplabs2.repository.AuthorRepository;
import com.example.wplabs2.repository.BookRepository;
import com.example.wplabs2.repository.BookStoreRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataInitializr {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final BookStoreRepository bookStoreRepository;

    public DataInitializr(AuthorRepository authorRepository, BookRepository bookRepository, BookStoreRepository bookStoreRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.bookStoreRepository = bookStoreRepository;
    }

    // dodavanje na avtori i knigi vo samata baza
    @PostConstruct
    public void initializeData() {

        for (int i = 0; i < 10; i++) {
            AuthorEntity authorEntity = new AuthorEntity(new AuthorFullName("Name" + i, "Surname" + i), "Biography" + i, LocalDate.now());
            authorRepository.save(authorEntity);
        }

        for (int i = 0; i < 6; i++) {
            BookEntity bookEntity = new BookEntity(Integer.toString(i + 251521), "Title" + i, "Genre" + i, i + 2000);
            bookRepository.save(bookEntity);
        }

        for (int i = 0; i < 5; i++) {
            BookStoreEntity bookStore = new BookStoreEntity("BookStore" + i, "City" + i, "Address" + i);
            bookStoreRepository.save(bookStore);
        }
    }
}
