package com.codingshuttle.youtube.learningRestAPIs.controller;

import com.codingshuttle.youtube.learningRestAPIs.dto.AddStudent;
import com.codingshuttle.youtube.learningRestAPIs.dto.StudentDto;
import com.codingshuttle.youtube.learningRestAPIs.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
    public ResponseEntity<StudentDto> createNewStudent(@RequestBody @Valid AddStudent addStudent ){
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.createNewStudent(addStudent));
    }

    @DeleteMapping("/deleteStudentById/{id}")
    public ResponseEntity<Void> deleteStudentById(@PathVariable Long id){
        studentService.deleteStudentById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/updateStudentById/{id}")
    public ResponseEntity<StudentDto> updateStudentById(@PathVariable Long id,
                                                        @RequestBody AddStudent addStudent){
        return ResponseEntity.ok(studentService.updateStudent(id, addStudent));
    }

    @PatchMapping("/updatePartialStudent/{id}")
    public ResponseEntity<StudentDto> updatePartialStudent(@PathVariable Long id,
                                                           @RequestBody Map<String, Object> updates){
        return ResponseEntity.ok(studentService.updatePartialStudent(id, updates));
    }
}
