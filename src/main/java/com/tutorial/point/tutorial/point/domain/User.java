package com.tutorial.point.tutorial.point.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
@Builder
@Getter
@Setter
@Document(collection = "User")
public class User {
    @Id
    String uuid;
    String fName;
    String lName;
    String email;
    @Field(name = "course_enrolledTo")
    List<String> courseEnrolledTo;
    @Field(name = "course_inCart")
    List<String> courseInCart;
    String mobileNumber;

    @PersistenceConstructor
    public User() {
    }
}
