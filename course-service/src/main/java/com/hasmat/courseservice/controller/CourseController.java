package com.hasmat.courseservice.controller;

import com.hasmat.courseservice.model.Course;
import com.hasmat.courseservice.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    //Create course
    @PostMapping
    public ResponseEntity<Course> createCourse(@RequestBody Course course){
        Course course1 = courseService.saveCourse(course);
        return  ResponseEntity.status(HttpStatus.CREATED).body(course1);
    }

    //GetAllCourse
    @GetMapping
    public ResponseEntity<List<Course>> getAllCourse(){
        List<Course> allCourses = courseService.fetchAllCourse();
        return ResponseEntity.ok(allCourses);
    }

    //Get course by id
    @GetMapping("/{courseId}")
    public ResponseEntity<Course> getCourseById(@PathVariable String courseId){
        Course course = courseService.fetchCourseById(courseId);
        return ResponseEntity.ok(course);
    }

}
