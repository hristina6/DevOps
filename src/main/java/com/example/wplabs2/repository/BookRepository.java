package com.example.wplabs2.repository;

import com.example.wplabs2.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


// kreiranje na repository za da pristapime do tabelata za knigi
@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {
    BookEntity findByIsbn(String isbn);
}
