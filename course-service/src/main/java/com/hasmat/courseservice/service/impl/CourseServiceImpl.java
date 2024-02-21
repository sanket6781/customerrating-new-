package com.hasmat.courseservice.service.impl;

import com.hasmat.courseservice.exception.ResourceNotFoundException;
import com.hasmat.courseservice.model.Course;
import com.hasmat.courseservice.repository.CourseRepository;
import com.hasmat.courseservice.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseRepository courseRepository;
    @Override
    public Course saveCourse(Course course) {
        String createCourseId = UUID.randomUUID().toString();
        course.setCourseId(createCourseId);
        return courseRepository.save(course);
    }

    @Override
    public List<Course> fetchAllCourse() {
        return courseRepository.findAll();
    }

    @Override

    public Course fetchCourseById(String courseId) {
        return courseRepository.findById(courseId).orElseThrow(() -> new ResourceNotFoundException("Hotel with the given id does not exist! " +courseId));
    }
}
