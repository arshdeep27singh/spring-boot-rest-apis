package com.codingshuttle.youtube.learningRestAPIs.service.impl;

import com.codingshuttle.youtube.learningRestAPIs.dto.AddStudent;
import com.codingshuttle.youtube.learningRestAPIs.dto.StudentDto;
import com.codingshuttle.youtube.learningRestAPIs.entity.Student;
import com.codingshuttle.youtube.learningRestAPIs.repository.StudentRepository;
import com.codingshuttle.youtube.learningRestAPIs.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        return students.stream().map(student -> new StudentDto(
                student.getId(),
                student.getName(),
                student.getEmail()
        )).toList();
    }

    @Override
    public StudentDto getStudentsById(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Student not " +
                "found with id: " + id));
        return modelMapper.map(student, StudentDto.class);
    }

    @Override
    public StudentDto createNewStudent(AddStudent addStudent) {
        Student newStudent = modelMapper.map(addStudent, Student.class);
        Student student = studentRepository.save(newStudent);
        return modelMapper.map(student, StudentDto.class);
    }
}
