package com.khushi.course.service.impl;

import com.khushi.course.dto.courseDto;
import com.khushi.course.entity.course;
import com.khushi.course.mapper.courseMapper;
import com.khushi.course.repository.courseRepository;
import com.khushi.course.service.InterCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class interCourseImpl implements InterCourse {

    @Autowired
    private courseRepository repository;

    @Override
    public void createCourse(courseDto courseDto) {
        course cours = courseMapper.mapToCourse(courseDto, new course());
        repository.save(cours);
    }

    @Override
    public boolean updateCourse(courseDto courseDto){
        boolean isUpdated = false;
        if(courseDto.getTitle() == null){
            return isUpdated;
        }
        course core = repository.findByTitle(courseDto.getTitle())
                .orElseThrow(() -> new NoSuchElementException("Course with title '" + courseDto.getTitle() + "' not found"));
        course update = courseMapper.mapToCourse(courseDto,core);
        repository.save(update);
        isUpdated = true;
        return isUpdated;
    }

    @Override
    public courseDto fetchCourse(String title){
        course cour = repository.findByTitle(title).orElseThrow(
                () -> new NoSuchElementException("Course with title " + title + " not found")
        );

        courseDto core = courseMapper.mapToCourseDto(cour,new courseDto());
        return core;
    }

    @Override
    public boolean deleteCourse(String title){
        boolean isdel = false;
        if(title == null) {
            return isdel;
        }
        repository.findByTitle(title).orElseThrow(
                () -> new NoSuchElementException("Course with title " + title + " not found")
        );

        repository.deleteByTitle(title);
        isdel = true;
        return isdel;
    }

}
