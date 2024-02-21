package com.hasmat.studentservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "student-tbl")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @Column(name = "STUDENT_ID")
    private String studentId;

    @Column(name = "STUDENT_NAME")
    private String studentName;

    @Column(name = "STUDENT_AGE")
    private int studentAge;

    @Column(name = "STUDENT_SCHOOL_NAME")
    private String studentSchoolName;

    @Transient
    private List<Rating> ratings = new ArrayList<>();
}
