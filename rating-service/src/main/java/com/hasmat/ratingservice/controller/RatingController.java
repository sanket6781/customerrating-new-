package com.hasmat.ratingservice.controller;

import com.hasmat.ratingservice.model.Rating;
import com.hasmat.ratingservice.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rating")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    //create rating
    @PostMapping
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating){
        Rating rating1 = ratingService.saveRating(rating);
        return  ResponseEntity.status(HttpStatus.CREATED).body(rating1);
    }

    //get all ratings
    @GetMapping
    public ResponseEntity<List<Rating>> getAllRatings(){
        List<Rating> allRatings = ratingService.fetchAllRating();
        return  ResponseEntity.ok(allRatings);
    }

    //get rating by student id
    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<Rating>> getRatingByStudentId(@PathVariable String studentId){
        return ResponseEntity.ok(ratingService.fetchRatingByStudentId(studentId));
    }

    //get rating by course id
    @GetMapping("/course/{courseId}")
    public ResponseEntity<List<Rating>> getRatingByCourseId(@PathVariable String courseId){
        return ResponseEntity.ok(ratingService.fetchRatingByCourseId(courseId));
    }



}
