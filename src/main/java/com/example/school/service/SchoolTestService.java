package com.example.school.service;

import com.example.school.converter.SchoolTestConverter;
import com.example.school.dto.SchoolTestDto;
import com.example.school.entity.SchoolTestEntity;
import com.example.school.repository.SchoolTestRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SchoolTestService {

    private final SchoolTestRepository schoolTestRepository;
    private final SchoolTestConverter schoolTestConverter;

    public void addSchoolTest(SchoolTestDto schoolTestDto) {
        SchoolTestEntity convertedSchoolTest = schoolTestConverter.convertToEntity(schoolTestDto);
        schoolTestRepository.save(convertedSchoolTest);
    }

    public SchoolTestDto getSchoolTest(String id) {
        SchoolTestEntity schoolTestEntity = schoolTestRepository.findById(id).orElseThrow(NullPointerException::new);
        return schoolTestConverter.convertToDto(schoolTestEntity);
    }
}
