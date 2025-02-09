package com.example.wplabs2.service.author.impl;

import com.example.wplabs2.entity.AuthorEntity;
import com.example.wplabs2.repository.AuthorRepository;
import com.example.wplabs2.service.author.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }


    // metod koj gi vrakja site avtori, samoto repository ima metod koj gi zima site
    // avtori od baza
    @Override
    public List<AuthorEntity> findAll() {
        return authorRepository.findAll();
    }

    // metod koj vrakja eden avtor spored negovoto ID, samoto repository ima metod koj go bara
    // avtorot
    @Override
    public Optional<AuthorEntity> findById(Long id) {
        return authorRepository.findById(id);
    }
}
