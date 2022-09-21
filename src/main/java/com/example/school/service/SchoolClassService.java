package com.example.school.service;

import com.example.school.converter.SchoolClassConverter;
import com.example.school.dto.SchoolClassDto;
import com.example.school.entity.SchoolClassEntity;
import com.example.school.repository.SchoolClassRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SchoolClassService {

    private final SchoolClassRepository schoolClassRepository;
    private final SchoolClassConverter schoolClassConverter;

    public void addSchoolClass(SchoolClassDto schoolClassDto) {
        SchoolClassEntity convertedSchoolClass = schoolClassConverter.convertToEntity(schoolClassDto);
        schoolClassRepository.save(convertedSchoolClass);
    }

    public SchoolClassDto getSchoolClass(String id) {
        SchoolClassEntity schoolClassEntity = schoolClassRepository.findById(id).orElseThrow(NullPointerException::new);
        SchoolClassDto convertedSchoolClass = schoolClassConverter.convertToDto(schoolClassEntity);
        return convertedSchoolClass;
    }
}
