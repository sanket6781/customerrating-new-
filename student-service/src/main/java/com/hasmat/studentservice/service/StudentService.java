package com.hasmat.studentservice.service;

import com.hasmat.studentservice.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    //Create student
    Student saveStudent (Student student);

    //Get all students
    List<Student> fetchAllStudent();

    //Get student by studentId
    Student fetchStudentById(String studentId);
}
