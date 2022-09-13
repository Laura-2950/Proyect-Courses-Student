package com.dh.courseservice.service;


import com.dh.courseservice.model.dto.StudentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "student-service")
public interface StudentFeignClient {

    @GetMapping("/students/findAll")
    List<StudentDTO> findAll(@RequestParam Boolean throwError);
}
