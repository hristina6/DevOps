package com.example.wplabs2.service.review.impl;

import com.example.wplabs2.entity.BookEntity;
import com.example.wplabs2.entity.ReviewEntity;
import com.example.wplabs2.repository.BookRepository;
import com.example.wplabs2.repository.ReviewRepository;
import com.example.wplabs2.service.review.ReviewService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final BookRepository bookRepository;
    private final ReviewRepository reviewRepository;

    public ReviewServiceImpl(BookRepository bookRepository, ReviewRepository reviewRepository) {
        this.bookRepository = bookRepository;
        this.reviewRepository = reviewRepository;
    }

    @Override
    public void addReview(Long bookId, Integer score, String description, LocalDateTime timestamp) throws Exception {
        BookEntity book = bookRepository.findById(bookId).orElseThrow(Exception::new);
        reviewRepository.save(new ReviewEntity(score, description, book, timestamp));
    }

    @Override
    public List<ReviewEntity> findAll() {
        return reviewRepository.findAll();
    }

    @Override
    public List<ReviewEntity> filter(LocalDateTime from, LocalDateTime to) {
        return reviewRepository.findAllByTimestampBetween(from, to);
    }
}
