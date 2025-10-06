package com.codingshuttle.youtube.learningRestAPIs.controller;

import com.codingshuttle.youtube.learningRestAPIs.dto.AddStudent;
import com.codingshuttle.youtube.learningRestAPIs.dto.StudentDto;
import com.codingshuttle.youtube.learningRestAPIs.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<List<StudentDto>> getAllStudents(){
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable Long id){
        return ResponseEntity.ok(studentService.getStudentsById(id));
    }

    @PostMapping("/createStudent")
    public ResponseEntity<StudentDto> createNewStudent(@RequestBody AddStudent addStudent ){
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.createNewStudent(addStudent));
    }
}
