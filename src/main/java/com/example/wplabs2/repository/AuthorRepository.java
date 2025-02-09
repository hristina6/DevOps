package com.example.wplabs2.repository;

import com.example.wplabs2.entity.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


// kreiranje na repository za da pristapime do tabelata za avtori
@Repository
public interface AuthorRepository extends JpaRepository<AuthorEntity,Long> {
}
