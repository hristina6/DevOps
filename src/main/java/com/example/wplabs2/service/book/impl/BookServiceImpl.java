package com.example.wplabs2.service.book.impl;

import com.example.wplabs2.entity.AuthorEntity;
import com.example.wplabs2.entity.BookEntity;
import com.example.wplabs2.entity.BookStoreEntity;
import com.example.wplabs2.repository.AuthorRepository;
import com.example.wplabs2.repository.BookRepository;
import com.example.wplabs2.repository.BookStoreRepository;
import com.example.wplabs2.service.book.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final BookStoreRepository bookStoreRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository, BookStoreRepository bookStoreRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.bookStoreRepository = bookStoreRepository;
    }

    // metod koj gi vrakja site knigi, samoto repository ima takov metod
    @Override
    public List<BookEntity> findAll() {
        return bookRepository.findAll();
    }

    // metod koj vrakja kniga spored ISBN, samoto repository ima takov metod
    // ako ne najde kniga so takvo ISBN, frla exception
    @Override
    public BookEntity findByIsbn(String isbn) throws Exception {
        return bookRepository.findByIsbn(isbn);
    }

    // metod koj dodava avtor za samata kniga
    // prvo go barame avtorot spored negovoto ID, pa potoa knigata spored ISBN
    // ako ne najdeme, frlame exception
    // proveruvame dali vekje go imame toj avtor za taa kniga, ako go nemame samo togas go dodavame
    // i zacuvuvame na kraj vo baza preku save() metodot koj go ima samoto repository
    @Override
    public AuthorEntity addAuthorToBook(Long authorId, String isbn) throws Exception {
        AuthorEntity author = authorRepository.findById(authorId).orElseThrow(Exception::new);

        BookEntity book = bookRepository.findByIsbn(isbn);

        if (!author.getBooks().contains(book)) {
            author.getBooks().add(book);
        }

        if(!book.getAuthors().contains(author)) {
            book.getAuthors().add(author);
        }

        bookRepository.save(book);
        authorRepository.save(author);
        return author;
    }

    @Override
    public BookEntity findById(Long id) throws Exception {
        return bookRepository.findById(id).orElseThrow(Exception::new);
    }

    @Override
    public void addBook(String isbn, String title, String genre, int year, Long bookStoreId) throws Exception {
        BookStoreEntity bookStore = bookStoreRepository.findById(bookStoreId).orElseThrow(Exception::new);
        bookRepository.save(new BookEntity(isbn, title, genre, year, bookStore));
    }

    @Override
    public void editBook(Long id, String isbn, String title, String genre, int year, Long bookStoreId) throws Exception {
        BookStoreEntity bookStore = bookStoreRepository.findById(bookStoreId).orElseThrow(Exception::new);
        BookEntity book = bookRepository.findById(id).orElseThrow(Exception::new);

        book.setIsbn(isbn);
        book.setTitle(title);
        book.setGenre(genre);
        book.setYear(year);
        book.setBookStore(bookStore);

        bookRepository.save(book);
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }


}
