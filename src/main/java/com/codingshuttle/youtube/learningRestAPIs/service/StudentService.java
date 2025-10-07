package com.codingshuttle.youtube.learningRestAPIs.service;

import com.codingshuttle.youtube.learningRestAPIs.dto.AddStudent;
import com.codingshuttle.youtube.learningRestAPIs.dto.StudentDto;

import java.util.List;
import java.util.Map;

public interface StudentService{
    List<StudentDto> getAllStudents();

    StudentDto getStudentsById(Long id);

    StudentDto createNewStudent(AddStudent addStudent);

    void deleteStudentById(Long id);

    StudentDto updateStudent(Long id, AddStudent addStudent);

    StudentDto updatePartialStudent(Long id, Map<String, Object> updates);
}
