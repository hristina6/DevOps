package com.example.wplabs2.controller;

import com.example.wplabs2.service.book.BookService;
import com.example.wplabs2.service.bookstore.BookStoreService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

// kontrolerot sluzi za da primame REQUEST od klienti
@Controller
public class BookController {

    private final BookService bookService;
    private final BookStoreService bookStoreService;

    public BookController(BookService bookService, BookStoreService bookStoreService) {
        this.bookService = bookService;
        this.bookStoreService = bookStoreService;
    }


    @GetMapping("/books")
    public String getBooksPage(Model model) {
        model.addAttribute("books", bookService.findAll());
        return "listBooks";
    }

    @GetMapping("/books/add-form")
    public String getAddBookPage(Model model) {
        model.addAttribute("bookStores", bookStoreService.findAll());
        return "add-book";
    }

    @GetMapping("/books/edit-form/{id}")
    public String getEditBookPage(@PathVariable(name = "id") Long id, Model model) throws Exception {
        model.addAttribute("book", bookService.findById(id));
        model.addAttribute("bookStores", bookStoreService.findAll());
        return "add-book";
    }

    @PostMapping("/books/add")
    public String addBook(@RequestParam(name = "isbn") String isbn,
                          @RequestParam(name = "title") String title,
                          @RequestParam(name = "genre") String genre,
                          @RequestParam(name = "year") int year,
                          @RequestParam(name = "bookStoreId") Long bookStoreId) throws Exception {
        bookService.addBook(isbn, title, genre, year, bookStoreId);
        return "redirect:/books";
    }

    @PostMapping("/books/edit/{id}")
    public String editBook(@PathVariable(name = "id") Long id,
                           @RequestParam(name = "isbn") String isbn,
                           @RequestParam(name = "title") String title,
                           @RequestParam(name = "genre") String genre,
                           @RequestParam(name = "year") int year,
                           @RequestParam(name = "bookStoreId") Long bookStoreId) throws Exception {
        bookService.editBook(id, isbn, title, genre, year, bookStoreId);
        return "redirect:/books";
    }

    @GetMapping("/books/delete/{id}")
    public String deleteBook(@PathVariable(name = "id") Long id) {
        bookService.deleteBook(id);
        return "redirect:/books";
    }


}
