package com.myblog12.service.impl;

import com.myblog12.entity.Student;
import com.myblog12.exception.ResourceNotFound;
import com.myblog12.payload.StudentDto;
import com.myblog12.repository.StudentRepository;
import com.myblog12.service.StudentSource;
import org.springframework.stereotype.Service;

@Service
public class StudentSourceImpl implements StudentSource {

    private StudentRepository studentRepository;

    public StudentSourceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public StudentDto saveStudent(StudentDto studentDto) {

        Student student = mapToStudent(studentDto);

        Student save = studentRepository.save(student);

        StudentDto dto = mapToDto(save);
        return dto;

    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public StudentDto updateStudent(long id, StudentDto studentDto) {
        Student student = studentRepository.findById(id).orElseThrow(

                ()->new ResourceNotFound("Student Not Found:"+id)
        );
        student.setTitle(studentDto.getTitle());
        student.setDescription(studentDto.getDescription());
        student.setContent(studentDto.getContent());

        Student updateStudent = studentRepository.save(student);
        StudentDto updateDto = mapToDto(updateStudent);
        return updateDto;

    }

    @Override
    public StudentDto getById(long id) {

        Student student = studentRepository.findById(id).orElseThrow(
                () -> new ResourceNotFound("Student not Found:" + id)
        );

        StudentDto dto = mapToDto(student);
        return dto;
    }

    StudentDto mapToDto(Student save){
        StudentDto dto=new StudentDto();

        dto.setId(save.getId());
        dto.setTitle(save.getTitle());
        dto.setDescription(save.getDescription());
        dto.setContent(save.getContent());
        return dto;
    }

   Student mapToStudent(StudentDto studentDto){

       Student student=new Student();
       student.setId(studentDto.getId());
       student.setTitle(studentDto.getTitle());
       student.setDescription(studentDto.getDescription());
       student.setContent(studentDto.getContent());
       return student;

   }
}
