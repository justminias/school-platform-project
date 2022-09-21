package com.example.school.converter;

import com.example.school.dto.SchoolClassDto;
import com.example.school.entity.SchoolClassEntity;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
public class SchoolClassConverter implements Converter<SchoolClassDto, SchoolClassEntity> {

    @Override
    public SchoolClassEntity convertToEntity(SchoolClassDto schoolClassDto) {
        return SchoolClassEntity.builder()
                .id(schoolClassDto.getId() == null ? UUID.randomUUID().toString() : schoolClassDto.getId())
                .schoolGradeLevel(schoolClassDto.getSchoolGradeLevel())
                .build();
    }

    @Override
    public SchoolClassDto convertToDto(SchoolClassEntity schoolClassEntity) {
        return SchoolClassDto.builder()
                .id(schoolClassEntity.getId())
                .schoolGradeLevel(schoolClassEntity.getSchoolGradeLevel())
                .build();
    }
}
