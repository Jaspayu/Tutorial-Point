package com.tutorial.point.tutorial.point.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tutorial.point.tutorial.point.TutorialPointApplicationTests;
import com.tutorial.point.tutorial.point.domain.Course;
import com.tutorial.point.tutorial.point.repository.CourseRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CourseServiceTest extends TutorialPointApplicationTests {

    @Autowired
    CourseServiceImpl courseService;

    @Autowired
    CourseRepo courseRepo;

    @BeforeEach
    public void init() {
        saveCourse();
    }

    public void saveCourse() {
        String courseList = "[{\n" +
                "    \"courseId\": \"101\",\n" +
                "    \"courseName\": \"AWS\",\n" +
                "    \"price\": 1000.0,\n" +
                "    \"facultyName\": \"Payal Jasoriya\"\n" +
                "}," +
                "{\n" +
                "    \"courseId\": \"102\",\n" +
                "    \"courseName\": \"Java\",\n" +
                "    \"price\": 1100.0,\n" +
                "    \"facultyName\": \"Muskan Jasoriya\"\n" +
                "}," +
                "{\n" +
                "    \"courseId\": \"103\",\n" +
                "    \"courseName\": \"AWS\",\n" +
                "    \"price\": 900.0,\n" +
                "    \"facultyName\": \"Janvi Jasoriya\"\n" +
                "}]";


        try {
            Course[] courses = new ObjectMapper().readValue(courseList, Course[].class);

            for (Course course : courses) {
                courseRepo.save(course);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void fetchAllCourseListTest() {
        List<Course> courses = courseService.fetchAllCourseList();
        assertEquals(4, courses.size());
    }

    @Test
    public void fetchCourseByIDTest(){
        Course actualCourse = courseService.fetchCourseByID("101");
        Course expectedCourse = Course.builder().courseId("101").courseName("AWS")
                .price(1000d).facultyName("Payal Jasoriya").build();
        assertEquals(expectedCourse,actualCourse);
    }

    @Test
    public void fetchCourseByFacultyTest(){
        List<Course> courses = courseService.fetchCourseByFaculty("Muskan Jasoriya");
        assertEquals(1, courses.size());
    }

    @Test
    public void fetchCourseByNameTest(){
        List<Course> courses = courseService.fetchCourseByName("AWS");
        assertEquals(2, courses.size());
    }

    @Test
    public void saveCourseTest(){
        String course = "{\n" +
                "    \"courseId\": \"104\",\n" +
                "    \"courseName\": \"Python\",\n" +
                "    \"price\": 800.0,\n" +
                "    \"facultyName\": \"Akshay Kaushik\"\n" +
                "}";

        Course courses= null;
        try {
            courses = new ObjectMapper().readValue(course, Course.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        courseService.saveCourse(courses);
          assertEquals(4, courseService.fetchAllCourseList().size());
    }

}
