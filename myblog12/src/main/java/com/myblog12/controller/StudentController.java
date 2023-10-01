package com.myblog12.controller;

import com.myblog12.payload.StudentDto;
import com.myblog12.service.StudentSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/post")
public class StudentController {

    //http://localhost:8080/api/post

    private StudentSource studentSource;

    public StudentController(StudentSource studentSource) {
        this.studentSource = studentSource;
    }

    @PostMapping
    public ResponseEntity<StudentDto> saveStudent(@RequestBody StudentDto studentDto){
        StudentDto Dto = studentSource.saveStudent(studentDto);
        return new ResponseEntity<>(Dto, HttpStatus.CREATED);
    }
    //http://localhost:8080/api/post/1

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") Long id){
        studentSource.deleteStudent(id);
        return new ResponseEntity<>("Student is deleted",HttpStatus.OK);
    }

    //http://localhost:8080/api/post/1
    @PutMapping("/{id}")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable("id") long id,@RequestBody StudentDto studentDto){
        StudentDto updateDto = studentSource.updateStudent(id, studentDto);
       return new ResponseEntity<>(updateDto,HttpStatus.OK);
    }

    //http://localhost:8080/api/post/1
    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getById(@PathVariable("id") long id){
        StudentDto dto = studentSource.getById(id);
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }

}
