package com.myblog12.service;

import com.myblog12.payload.StudentDto;

public interface StudentSource {
    StudentDto saveStudent(StudentDto studentDto);

    void deleteStudent(Long id);

    StudentDto updateStudent(long id, StudentDto studentDto);

     StudentDto getById(long id);
}
