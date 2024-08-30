package com.khushi.course.mapper;

import com.khushi.course.dto.courseDto;
import com.khushi.course.entity.course;

public class courseMapper {

    public static course mapToCourse(courseDto coursDto, course cours){
        cours.setTitle(coursDto.getTitle());
        cours.setDuration(coursDto.getDuration());
        cours.setAuthor(coursDto.getAuthor());
        return cours;
    }

    public static courseDto mapToCourseDto(course cours, courseDto coursDto){
        coursDto.setTitle(cours.getTitle());
        coursDto.setDuration(cours.getDuration());
        coursDto.setAuthor(cours.getAuthor());
        return coursDto;
    }

}
