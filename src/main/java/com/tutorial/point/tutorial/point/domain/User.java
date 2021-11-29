package com.tutorial.point.tutorial.point.domain;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class User {
    String uuid;
    String fName;
    String lName;
    String email;
    String course_enrolledTo;
    String course_inCart;
    String mobileNumber;
}
