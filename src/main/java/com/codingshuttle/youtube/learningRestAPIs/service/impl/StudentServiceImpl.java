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
import java.util.Map;

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

    @Override
    public void deleteStudentById(Long id) {
        if(!studentRepository.existsById(id)){
            throw new IllegalArgumentException("Student not found with id: " + id);
        }
        studentRepository.deleteById(id);
    }

    @Override
    public StudentDto updateStudent(Long id, AddStudent addStudent) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Student not " +
                "found with Id " + id));
        modelMapper.map(addStudent, student);

        student = studentRepository.save(student);
        return modelMapper. map(student, StudentDto.class);
    }

    @Override
    public StudentDto updatePartialStudent(Long id, Map<String, Object> updates) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Student not " +
                        "found with Id " + id));
        updates.forEach((field, value) -> {
            switch(field){
                case "name" :
                    student.setName((String) value);
                    break;
                case "email" :
                    student.setEmail((String) value);
                    break;
                default: throw new IllegalArgumentException("field is not present");
            }
        });
         Student savedStudent = studentRepository.save(student);
         return modelMapper.map(savedStudent, StudentDto.class);
    }
}
