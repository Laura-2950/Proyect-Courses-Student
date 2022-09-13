package com.dh.courseservice.service;



import com.dh.courseservice.model.Course;
import com.dh.courseservice.model.dto.CourseDTO;
import com.dh.courseservice.model.dto.StudentDTO;
import com.dh.courseservice.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    private final StudentService studentService;
    private final CourseRepository courseRepository;

    @Autowired
    public CourseService(StudentService studentService, CourseRepository courseRepository){
        this.studentService=studentService;
        this.courseRepository=courseRepository;
    }

    public CourseDTO findCourseById(Integer id){
        Optional<Course> courseOptional= courseRepository.findById(id);
        List<StudentDTO>students=studentService.findAllStudents(/*Boolean.FALSE*/ Boolean.TRUE);
        CourseDTO courseDTO= new CourseDTO();
        courseOptional.ifPresent(course -> {
            courseDTO.setId(course.getId());
            courseDTO.setTitle(course.getTitle());
            courseDTO.setStudents(students);
        });
        return courseDTO;

    }


    public List<Course> findAll() {
        return courseRepository.findAll();
    }
}
