package com.hasmat.studentservice.controller;

import com.hasmat.studentservice.model.Student;
import com.hasmat.studentservice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    //create student
    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        Student student1 = studentService.saveStudent(student);
        return  ResponseEntity.status(HttpStatus.CREATED).body(student1);
    }

    //get all students
    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents(){
        List<Student> allStudents = studentService.fetchAllStudent();
        return  ResponseEntity.ok(allStudents);
    }

    //get student by id
    @GetMapping("/{studentId}")
    public ResponseEntity<Student> getStudentById(@PathVariable String studentId){
        Student student = studentService.fetchStudentById(studentId);
        return ResponseEntity.ok(student);
    }
}
