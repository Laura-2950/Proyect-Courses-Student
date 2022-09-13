package com.dh.courseservice.service;

import com.dh.courseservice.model.dto.StudentDTO;
import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    private Logger LOG= LoggerFactory.getLogger(StudentService.class);

    private final  StudentFeignClient studentFeignClient;

    @Autowired
    public StudentService(StudentFeignClient studentFeignClient){
        this.studentFeignClient=studentFeignClient;
    }

    @CircuitBreaker(name = "students", fallbackMethod = "studentFallbackMethod")
    @Retry(name = "students")
    public List<StudentDTO> findAllStudents(Boolean throwError){
        LOG.info("Estamos por obtener los estudiantes...");
        List<StudentDTO> students= studentFeignClient.findAll(throwError);
        return students;
    }

    private List<StudentDTO> studentFallbackMethod(CallNotPermittedException exception){
        LOG.info("Circuit breaker was active");
        return new ArrayList<>();
    }
}
