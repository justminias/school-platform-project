package com.example.school.converter;

import com.example.school.dto.StudentDto;
import com.example.school.entity.StudentEntity;
import com.example.school.repository.SchoolClassRepository;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class StudentConverter implements Converter<StudentDto, StudentEntity> {

    private final SchoolClassRepository schoolClassRepository;

    @Override
    public StudentEntity convertToEntity(StudentDto studentDto) {
        return StudentEntity.builder()
                .id(studentDto.getId() == null ? UUID.randomUUID().toString() : studentDto.getId())
                .name(studentDto.getName())
                .surname(studentDto.getSurname())
                .schoolClassEntity(schoolClassRepository.findBySchoolGradeLevel(studentDto.getSchoolGradeLevel()))
                .build();
    }

    @Override
    public StudentDto convertToDto(StudentEntity studentEntity) {
        return StudentDto.builder()
                .id(studentEntity.getId())
                .name(studentEntity.getName())
                .surname(studentEntity.getSurname())
                .schoolGradeLevel(studentEntity.getSchoolClassEntity().getSchoolGradeLevel())
                .build();
    }
}
