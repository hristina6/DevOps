package com.example.wplabs2.service.author;

import com.example.wplabs2.entity.AuthorEntity;

import java.util.List;
import java.util.Optional;

public interface AuthorService {

    List<AuthorEntity> findAll();

    Optional<AuthorEntity> findById(Long id);
}
