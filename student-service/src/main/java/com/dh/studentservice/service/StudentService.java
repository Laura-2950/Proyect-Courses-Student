package com.dh.studentservice.service;

import com.dh.studentservice.model.Student;
import com.dh.studentservice.repository.IStudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

  private IStudentRepository studentRepository;

  public StudentService(IStudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }

  public List<Student> findAll(Boolean throwError) {
    if (throwError)
      throw new RuntimeException();

    return studentRepository.findAll();
  }
}
