package com.example.school.service;

import com.example.school.converter.StudentConverter;
import com.example.school.dto.StudentDto;
import com.example.school.entity.StudentEntity;
import com.example.school.repository.StudentRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final StudentConverter studentConverter;

    public void addStudent(StudentDto studentDto) {
        StudentEntity convertedStudent = studentConverter.convertToEntity(studentDto);
        studentRepository.save(convertedStudent);
    }

    public StudentDto getStudent(String id) {
        StudentEntity studentEntity = studentRepository.findById(id).orElseThrow(NullPointerException::new);
        return studentConverter.convertToDto(studentEntity);
    }
}
