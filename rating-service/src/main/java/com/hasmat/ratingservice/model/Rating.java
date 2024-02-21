package com.hasmat.ratingservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("student_ratings")
public class Rating {

    @Id
    private String ratingId;
    private String studentId;
    private String courseId;
    private int rating;
    private String feedback;
}
