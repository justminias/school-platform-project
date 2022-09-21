package com.example.school.converter;

import com.example.school.dto.TeacherDto;
import com.example.school.entity.Subject;
import com.example.school.entity.TeacherEntity;
import com.example.school.entity.TeacherProfile;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
public class TeacherConverter implements Converter<TeacherDto, TeacherEntity> {

    @Override
    public TeacherEntity convertToEntity(TeacherDto teacherDto) {
        return TeacherEntity.builder()
                .id(teacherDto.getId() == null ? UUID.randomUUID().toString() : teacherDto.getId())
                .name(teacherDto.getName())
                .surname(teacherDto.getSurname())
                .teacherProfile(TeacherProfile.SUBJECT_TEACHER)
                .schoolClassEntity(null)
                .subjects(teacherDto.getSubjects())
                .build();
    }

    @Override
    public TeacherDto convertToDto(TeacherEntity teacherEntity) {
        return TeacherDto.builder()
                .id(teacherEntity.getId())
                .name(teacherEntity.getName())
                .surname(teacherEntity.getSurname())
                .teacherProfile(teacherEntity.getTeacherProfile())
                .classId(teacherEntity.getSchoolClassEntity() == null ? null : teacherEntity.getSchoolClassEntity().getId())
                .subjects(teacherEntity.getSubjects())
                .build();
    }
}
