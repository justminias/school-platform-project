package com.example.school.converter;

import com.example.school.dto.TestResultDto;
import com.example.school.entity.TestResultEntity;
import com.example.school.repository.SchoolTestRepository;
import com.example.school.repository.StudentRepository;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class TestResultConverter implements Converter<TestResultDto, TestResultEntity> {

    private final SchoolTestRepository schoolTestRepository;
    private final StudentRepository studentRepository;

    @Override
    public TestResultEntity convertToEntity(TestResultDto testResultDto) {
        return TestResultEntity.builder()
                .id(testResultDto.getId() == null ? UUID.randomUUID().toString() : testResultDto.getId())
                .schoolTestEntity(schoolTestRepository.getReferenceById(testResultDto.getTestId()))
                .studentEntity(studentRepository.getReferenceById(testResultDto.getStudentId()))
                .grade(testResultDto.getGrade())
                .build();
    }

    @Override
    public TestResultDto convertToDto(TestResultEntity testResultEntity) {
        return TestResultDto.builder()
                .id(testResultEntity.getId())
                .testId(testResultEntity.getSchoolTestEntity().getId())
                .studentId(testResultEntity.getStudentEntity().getId())
                .grade(testResultEntity.getGrade())
                .build();
    }
}
