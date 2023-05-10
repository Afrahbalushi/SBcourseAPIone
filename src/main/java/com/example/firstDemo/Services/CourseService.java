package com.example.firstDemo.Services;

import com.example.firstDemo.Models.Course;
import com.example.firstDemo.Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class CourseService {

    @Autowired
    CourseService courseService;

    @RequestMapping(value = "getById")
    public Course getCourseById(@RequestParam("id") Integer courseid){

       return courseService.getCourseById(courseid);

    }
}