package com.example.wplabs2.repository;

import com.example.wplabs2.entity.BookStoreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookStoreRepository extends JpaRepository<BookStoreEntity,Long> {
}
