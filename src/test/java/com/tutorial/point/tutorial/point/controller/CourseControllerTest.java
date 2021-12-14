package com.tutorial.point.tutorial.point.controller;

import com.tutorial.point.tutorial.point.domain.Course;
import com.tutorial.point.tutorial.point.service.CourseService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import java.util.List;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.data.mongodb.core.MongoTemplate;



@WebMvcTest(controllers = CourseController.class,  excludeAutoConfiguration = EmbeddedMongoAutoConfiguration.class)
class CourseControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    CourseService courseService;

    @Mock
    MongoTemplate mongoTemplate;

    @Test
    void checkFetchAllCourseAPI() throws Exception {
        Course course1  = Course.builder().courseId("101")
                            .courseName("Java")
                            .facultyName("Payal Jasoriya")
                            .price(200d).build();
        when(courseService.fetchAllCourseList()).thenReturn(List.of(course1));
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("course/fetchAllCourse")
                .accept(MediaType.APPLICATION_JSON);
        mockMvc.perform(requestBuilder).andExpect(status().isOk())
                .andExpect(content().json("[\n" +
                        "    {\n" +
                        "        \"courseId\": \"101\",\n" +
                        "        \"courseName\": \"Java\",\n" +
                        "        \"price\": 200.0,\n" +
                        "        \"facultyName\": \"Payal Jasoriya\"\n" +
                        "    },\n" +
                        "]"));

    }

}