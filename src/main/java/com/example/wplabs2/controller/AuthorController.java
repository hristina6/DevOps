package com.example.wplabs2.controller;

import com.example.wplabs2.service.author.AuthorService;
import com.example.wplabs2.service.book.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


// kontroler sluzi za da primame requests od klienti
@Controller
public class AuthorController {

    private final AuthorService authorService;
    private final BookService bookService;

    public AuthorController(AuthorService authorService, BookService bookService) {
        this.authorService = authorService;
        this.bookService = bookService;
    }


    // ovoj metod ke se povika pri POST request na pateka /author
    // prima eden parametar a toe ISBN na kniga
    // potoa vo Modelot gi dodavame site avtori i samiot isbn na knigata
    // i go vrakjame authorList.html
    @PostMapping("/author")
    public String getAuthorsPage(@RequestParam(name = "isbn") String isbn, Model model) throws Exception {
        model.addAttribute("authors", authorService.findAll());
        model.addAttribute("isbn", isbn);
        return "authorList";
    }

    // ovoj metod ke se povika pri POST request na pateka /addAuthorToBook
    // prima dva parametri, ID na avtor i ISBN na kniga
    // potoa povikuvame metod od servisot za da dodademe avtor na taa kniga
    // i vo modelot ja dodavame taa kniga
    // go vrakjame bookDetails.html
    @PostMapping("/addAuthorToBook")
    public String addAuthorToBook(@RequestParam(name = "authorId") Long authorId, @RequestParam(name = "isbn") String isbn, Model model) throws Exception {
        bookService.addAuthorToBook(authorId, isbn);
        model.addAttribute("book", bookService.findByIsbn(isbn));
        return "bookDetails";
    }
}
