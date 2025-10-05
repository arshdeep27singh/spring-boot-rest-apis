package com.codingshuttle.youtube.learningRestAPIs.service;

import com.codingshuttle.youtube.learningRestAPIs.dto.StudentDto;

import java.util.List;

public interface StudentService{
    List<StudentDto> getAllStudents();

    StudentDto getStudentsById(Long id);
}
