package com.example.wplabs2.entity;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;


@Entity
@Table
public class AuthorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // private String name;
    // private String surname;

    // private AuthorFullName (name, surname)
    //
    @Convert(converter = AuthorFullNameConverter.class)
    private AuthorFullName authorFullName;

    private String biography;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate dateOfBirth;

    @ManyToMany
    private List<BookEntity> books;

    public AuthorEntity() {
    }

    public AuthorEntity(AuthorFullName authorFullName, String biography, LocalDate dateOfBirth) {
        this.authorFullName = authorFullName;
        this.biography = biography;
        this.dateOfBirth = dateOfBirth;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AuthorFullName getAuthorFullName() {
        return authorFullName;
    }

    public void setAuthorFullName(AuthorFullName userFullName) {
        this.authorFullName = userFullName;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public List<BookEntity> getBooks() {
        return books;
    }

    public void setBooks(List<BookEntity> books) {
        this.books = books;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
