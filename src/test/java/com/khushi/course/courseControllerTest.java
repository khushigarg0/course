//package com.khushi.course;
//
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.khushi.course.dto.courseDto;
//import com.khushi.course.service.impl.interCourseImpl;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import static net.bytebuddy.matcher.ElementMatchers.is;
//import static org.mockito.Mockito.doNothing;
//import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@SpringBootTest
//@ExtendWith(SpringExtension.class)
//@AutoConfigureMockMvc
//public class courseControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @MockBean
//    private interCourseImpl courseImpl;
//
//    @Test
//    @DisplayName("GET /courses/create -Create")
//    public void createCourse() throws Exception{
//        courseDto courseDto = new courseDto("java","5min","khushi");
//        doNothing().when(courseImpl).createCourse(courseDto, "java");
//
//        mockMvc.perform(MockMvcRequestBuilders
//                        .post("/courses/create")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(courseDto)))
//                .andExpect(status().isCreated())
//                .andExpect(jsonPath("$.message", is("Created successfully")))
//                .andExpect(jsonPath("$.status", is("201")));
//    }
//
//}



package com.khushi.course;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.khushi.course.dto.courseDto;
import com.khushi.course.service.impl.interCourseImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
public class courseControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private interCourseImpl courseImpl;

    @Test
    @DisplayName("POST /courses/create - Create")
    public void createCourse() throws Exception {
        courseDto courseDto = new courseDto("java", "5min", "khushi");

        doNothing().when(courseImpl).createCourse(courseDto);

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/courses/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(courseDto)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.message").value("Created successfully"))
                .andExpect(jsonPath("$.status").value("201"));
    }
}

