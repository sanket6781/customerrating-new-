package com.hasmat.courseservice.service;

import com.hasmat.courseservice.model.Course;

import java.util.List;

public interface CourseService {

    Course saveCourse(Course course);

    List<Course> fetchAllCourse();

    Course fetchCourseById(String courseId);
}
