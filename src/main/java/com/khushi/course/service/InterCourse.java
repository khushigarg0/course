package com.khushi.course.service;

import com.khushi.course.dto.courseDto;

public interface InterCourse {
    void createCourse(courseDto courseDto);

    courseDto fetchCourse(String title);

    boolean updateCourse(courseDto courseDto);

    boolean deleteCourse( String title);

}
