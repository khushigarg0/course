package com.khushi.course.controller;

import com.khushi.course.dto.ResponseDto;
import com.khushi.course.dto.courseDto;
import com.khushi.course.service.InterCourse;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/courses")
public class courseController {

    @Autowired
    private InterCourse intCourse;

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createEmployee(@RequestBody courseDto courseDto){
        intCourse.createCourse(courseDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                new ResponseDto("Created successfully", "201")
        );
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateCourse (@RequestBody courseDto courseDto){
        boolean isUpdated = intCourse.updateCourse(courseDto);
        if(isUpdated){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseDto("update Successfully", "202")
            );
        }else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    new ResponseDto("Not updated", "501")
            );
        }

    }

    @GetMapping("/fetchCourse")
    public ResponseEntity<courseDto> fetchCourse(@RequestParam String title){
        courseDto cou = intCourse.fetchCourse(title);
        return ResponseEntity.status(HttpStatus.OK).body(cou);
    }

    @DeleteMapping("deleteCourse")
    public ResponseEntity<ResponseDto> deleteCourse(@RequestParam String title){
        boolean isDeleted =  intCourse.deleteCourse(title);
        if(isDeleted){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseDto("Deleted Successfully", "200"));
        }else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    new ResponseDto("Not deleted", "501"));
        }
    }
//
//    @PostMapping("/enroll")
//    public ResponseEntity<ResponseDto> enroll(@RequestBody String title){
//
//
//        intCourse.createCourse(courseDto);
//        return ResponseEntity.status(HttpStatus.CREATED).body(
//                new ResponseDto("Created successfully", "201")
//        );
//    }

    @GetMapping("/greet")
    private String greet(){
        return "wlcm to courses";
    }
}



//@Override
//public void enrollEmployee(String mobileNo, String title){
//    CourseEntity courseEntity=courseRepository.findByTitle(title).orElseThrow(
//            () -> new CourseAlreadyExistsException("Course does not exist")
//    );
//    int c_id=courseEntity.getC_id();
//    Integer emp_id= restTemplate.getForObject("http://localhost:8090/fetch-id?mobileNumber="+mobileNo, Integer.class);
//    EnrollmentEntity enroll=new EnrollmentEntity(1,emp_id,c_id,false);
//    EnrollDto enrollDto=new EnrollDto();
////        Optional<EnrollmentEntity> enrollmentEntity=enrollRepository.f
//}