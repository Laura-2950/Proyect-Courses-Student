package com.dh.courseservice.controller;


import com.dh.courseservice.model.Course;
import com.dh.courseservice.model.dto.CourseDTO;
import com.dh.courseservice.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class Coursecontroller {
    private final CourseService courseService;

    @Autowired
    public Coursecontroller(CourseService courseService){
        this.courseService=courseService;
    }

    @GetMapping("/{id}")
    public CourseDTO findCourseById(@PathVariable("id") Integer id){
        return this.courseService.findCourseById(id);
    }

    @GetMapping
    public List<Course> findAllCourses(){
        return this.courseService.findAll();
    }
}
