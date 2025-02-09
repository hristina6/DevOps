package com.example.wplabs2.controller;

import com.example.wplabs2.service.review.ReviewService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;

@Controller
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/books/review/{id}")
    public String reviewBook(@PathVariable(name = "id") Long id, Model model) {
        model.addAttribute("bookId", id);
        return "review";
    }

    @PostMapping("/books/review/{id}")
    public String reviewBook(@PathVariable(name = "id") Long id,
                             @RequestParam(name = "score") Integer score,
                             @RequestParam(name = "description") String description,
                             @RequestParam(name = "timestamp") LocalDateTime timestamp) throws Exception {
        reviewService.addReview(id, score, description, timestamp);
        return "redirect:/books";
    }

    @GetMapping("/review")
    public String getReviewPage(Model model) {
        model.addAttribute("reviews", reviewService.findAll());
        return "listReview";
    }

    @GetMapping("/books/filter/timestamp")
    public String filterReviews(@RequestParam(name = "from") LocalDateTime from,
                                @RequestParam(name = "to") LocalDateTime to,
                                Model model) {
        model.addAttribute("reviews", reviewService.filter(from, to));
        return "listReview";
    }
}
