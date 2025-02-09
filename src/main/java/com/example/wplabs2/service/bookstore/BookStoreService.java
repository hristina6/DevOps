package com.example.wplabs2.service.bookstore;

import com.example.wplabs2.entity.BookStoreEntity;

import java.util.List;

public interface BookStoreService {
    List<BookStoreEntity> findAll();
}
