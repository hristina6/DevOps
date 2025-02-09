package com.example.wplabs2.service.bookstore.impl;

import com.example.wplabs2.entity.BookStoreEntity;
import com.example.wplabs2.repository.BookStoreRepository;
import com.example.wplabs2.service.bookstore.BookStoreService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookStoreServiceImpl implements BookStoreService {

    private final BookStoreRepository bookStoreRepository;

    public BookStoreServiceImpl(BookStoreRepository bookStoreRepository) {
        this.bookStoreRepository = bookStoreRepository;
    }

    @Override
    public List<BookStoreEntity> findAll() {
        return bookStoreRepository.findAll();
    }
}
