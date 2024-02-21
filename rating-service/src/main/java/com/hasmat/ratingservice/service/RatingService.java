package com.hasmat.ratingservice.service;

import com.hasmat.ratingservice.model.Rating;

import java.util.List;

public interface RatingService {

    Rating saveRating(Rating rating);

    List<Rating> fetchAllRating();

    List<Rating> fetchRatingByStudentId(String studentId);

    List<Rating> fetchRatingByCourseId(String courseId);


}
