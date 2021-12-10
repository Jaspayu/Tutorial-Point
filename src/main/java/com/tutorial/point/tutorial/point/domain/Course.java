package com.tutorial.point.tutorial.point.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@AllArgsConstructor
@Component
@Data
@Document(collection = "Course")
public class Course {
    @Id
    String courseId;
    String courseName;
    double price;
    String facultyName;
}
