package com.example.firstDemo.Services;

import com.example.firstDemo.Models.Course;
import com.example.firstDemo.Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

    @Autowired
    CourseRepository courseRepository;

    public Course getCourseById(Integer id){
        Course course = courseRepository.getCourseById(id);
        return course;
    }
}