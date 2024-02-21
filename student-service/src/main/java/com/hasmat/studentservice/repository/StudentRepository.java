package com.hasmat.studentservice.repository;

import com.hasmat.studentservice.model.Rating;
import com.hasmat.studentservice.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, String> {

}
