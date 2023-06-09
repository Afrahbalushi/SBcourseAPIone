package com.example.firstDemo.Controller;

import com.example.firstDemo.Models.Course;
import com.example.firstDemo.Services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "course")
public class CourseController {

    @Autowired
    CourseService courseService;

    @RequestMapping(value = "getById", method = RequestMethod.GET)
    public Course getCourseById(@RequestParam Integer courseId) throws Exception {
        if(courseId == 0)
            throw new Exception();
        return courseService.getCourseById(courseId);

    }
}
