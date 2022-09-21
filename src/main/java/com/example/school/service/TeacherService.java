package com.example.school.service;

import com.example.school.converter.TeacherConverter;
import com.example.school.dto.TeacherDto;
import com.example.school.entity.TeacherEntity;
import com.example.school.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;
    private final TeacherConverter teacherConverter;

    public void addTeacher(TeacherDto teacherDto) {
        TeacherEntity convertedTeacher = teacherConverter.convertToEntity(teacherDto);
        teacherRepository.save(convertedTeacher);
    }

    public TeacherDto getTeacher(String id) {
        TeacherEntity teacherEntity = teacherRepository.findById(id).orElseThrow(NullPointerException::new);
        return teacherConverter.convertToDto(teacherEntity);
    }
}
