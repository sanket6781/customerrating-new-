package com.hasmat.ratingservice.service.impl;

import com.hasmat.ratingservice.model.Rating;
import com.hasmat.ratingservice.repository.RatingRepository;
import com.hasmat.ratingservice.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    @Override
    public Rating saveRating(Rating rating) {
        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> fetchAllRating() {
        return ratingRepository.findAll();
    }

    @Override
    public List<Rating> fetchRatingByStudentId(String studentId) {
        return ratingRepository.findByStudentId(studentId);
    }

    @Override
    public List<Rating> fetchRatingByCourseId(String courseId) {
        return ratingRepository.findByCourseId(courseId);
    }

}
