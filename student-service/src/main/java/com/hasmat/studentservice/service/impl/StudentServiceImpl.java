package com.hasmat.studentservice.service.impl;

import com.hasmat.studentservice.exception.ResourceNotFoundException;
import com.hasmat.studentservice.external.service.CourseService;
import com.hasmat.studentservice.model.Course;
import com.hasmat.studentservice.model.Rating;
import com.hasmat.studentservice.model.Student;
import com.hasmat.studentservice.repository.StudentRepository;
import com.hasmat.studentservice.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CourseService courseService;

    private Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);

    @Override
    public Student saveStudent(Student student) {
        String createStudentId = UUID.randomUUID().toString();
        student.setStudentId(createStudentId);
        return studentRepository.save(student);
    }

    @Override
    //do the same as we did in fetchStudentById
    public List<Student> fetchAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public Student fetchStudentById(String studentId) {
        Student student = studentRepository.findById(studentId).orElseThrow(()-> new ResourceNotFoundException("User with the given id does not exist! " + studentId));
        //fetch rating of above user from rating service by api call to rating service
        Rating[] studentRatings = restTemplate.getForObject("http://RATING-SERVICE/rating/student/"+student.getStudentId(), Rating[].class);
        logger.info("{} ", studentRatings);

        List<Rating> ratings = Arrays.stream(studentRatings).toList();

        List<Rating> ratingList = ratings.stream().map(rating -> {

            //api call to course service to get the course
           // ResponseEntity<Course> forEntity = restTemplate.getForEntity("http://COURSE-SERVICE/course/"+rating.getCourseId(), Course.class);

            //Using Feign client instead of Rest Template
            Course course = courseService.getCourse(rating.getCourseId());

            // logger.info("Response Status Code: {} ", forEntity.getStatusCode());

            //set the course to rating
            rating.setCourse(course);

            // return the rating
            return rating;
        }).collect(Collectors.toList());

        student.setRatings(ratingList);
        return student;
    }
}
