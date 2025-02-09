package com.example.wplabs2.repository;

import com.example.wplabs2.entity.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<ReviewEntity, Long> {

    // select * from review where timestamp >= from and timestamp <= to
    // Hibernate
    //
    List<ReviewEntity> findAllByTimestampBetween(LocalDateTime from, LocalDateTime to);



}
