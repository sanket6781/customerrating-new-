package com.hasmat.courseservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "course-tbl")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {

    @Id
    private String courseId;
    private String courseName;
    private String courseDescription;

}
