package com.hasmat.studentservice.external.service;

import com.hasmat.studentservice.model.Course;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "COURSE-SERVICE")
public interface CourseService {

    @GetMapping("/course/{courseId}")
    Course getCourse(@PathVariable("courseId") String courseId);
}
