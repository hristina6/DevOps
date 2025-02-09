package com.example.wplabs2.entity;

import jakarta.persistence.*;

import java.util.List;


@Entity
@Table
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String isbn;

    private String title;

    private String genre;

    @Column(name = "year_book")
    private int year;

    @ManyToMany
    private List<AuthorEntity> authors;

    @ManyToOne
    private BookStoreEntity bookStore;


    public BookEntity() {
    }

    public BookEntity(String isbn, String title, String genre, int year, BookStoreEntity bookStore) {
        this.isbn = isbn;
        this.title = title;
        this.genre = genre;
        this.year = year;
        this.bookStore = bookStore;
    }



    public BookEntity(String isbn, String title, String genre, int year) {
        this.isbn = isbn;
        this.title = title;
        this.genre = genre;
        this.year = year;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<AuthorEntity> getAuthors() {
        return authors;
    }

    public void setAuthors(List<AuthorEntity> authors) {
        this.authors = authors;
    }

    public BookStoreEntity getBookStore() {
        return bookStore;
    }

    public void setBookStore(BookStoreEntity bookStore) {
        this.bookStore = bookStore;
    }

}
