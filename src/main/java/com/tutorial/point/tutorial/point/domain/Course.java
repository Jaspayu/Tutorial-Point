package com.tutorial.point.tutorial.point.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;


@NoArgsConstructor
@AllArgsConstructor
@Component
@Data
@Document(collection = "Course")
@Builder
public class Course {
    @Id
    String courseId;
    String courseName;
    double price;
    String facultyName;


}
