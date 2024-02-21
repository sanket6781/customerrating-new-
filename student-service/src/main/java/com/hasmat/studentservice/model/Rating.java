package com.hasmat.studentservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rating {
    private String ratingId;
    private String studentId;
    private String courseId;
    private int rating;
    private String feedback;

    private Course course;
}
