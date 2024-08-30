package com.khushi.course.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class enrollmentDto {

    public Integer id;
    public Integer course_id;
    public String status;
}
