package com.example.school.converter;

import com.example.school.dto.SchoolTestDto;
import com.example.school.entity.SchoolTestEntity;
import com.example.school.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class SchoolTestConverter implements Converter<SchoolTestDto, SchoolTestEntity> {

    private final TeacherRepository teacherRepository;

    @Override
    public SchoolTestEntity convertToEntity(SchoolTestDto schoolTestDto) {
        return SchoolTestEntity.builder()
                .id(schoolTestDto.getId() == null ? UUID.randomUUID().toString() : schoolTestDto.getId())
                .date(schoolTestDto.getDate())
                .teacherEntity(teacherRepository.getReferenceById(schoolTestDto.getTeacherId()))
                .subject(schoolTestDto.getSubject())
                .build();
    }

    @Override
    public SchoolTestDto convertToDto(SchoolTestEntity schoolTestEntity) {
        return SchoolTestDto.builder()
                .id(schoolTestEntity.getId())
                .date(schoolTestEntity.getDate())
                .teacherId(schoolTestEntity.getTeacherEntity().getId())
                .subject(schoolTestEntity.getSubject())
                .build();
    }
}
