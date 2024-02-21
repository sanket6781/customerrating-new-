package com.hasmat.ratingservice.repository;

import com.hasmat.ratingservice.model.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RatingRepository extends MongoRepository<Rating, String> {

    //Custom Finder Methods
    List<Rating> findByStudentId(String studentId);

    List<Rating> findByCourseId(String courseId);
}
