package com.example.wplabs2.service.review;

import com.example.wplabs2.entity.BookEntity;
import com.example.wplabs2.entity.ReviewEntity;

import java.time.LocalDateTime;
import java.util.List;

public interface ReviewService {

    void addReview(Long bookId, Integer score, String description, LocalDateTime timestamp) throws Exception;

    List<ReviewEntity> findAll();

    List<ReviewEntity> filter(LocalDateTime from, LocalDateTime to);
}
