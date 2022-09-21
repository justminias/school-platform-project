package com.example.school.service;

import com.example.school.converter.TestResultConverter;
import com.example.school.dto.*;
import com.example.school.entity.StudentDoesNotExistException;
import com.example.school.entity.StudentEntity;
import com.example.school.entity.TestResultDoesNotExistException;
import com.example.school.entity.TestResultEntity;
import com.example.school.repository.StudentRepository;
import com.example.school.repository.TestResultRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class TestResultService {

    private final TestResultRepository testResultRepository;
    private final TestResultConverter testResultConverter;
    private final StudentRepository studentRepository;

    public void addTestResult(TestResultDto testResultDto) {
        TestResultEntity convertedTestResult = testResultConverter.convertToEntity(testResultDto);
        testResultRepository.save(convertedTestResult);
    }

    public TestResultResponse getTestResult(TestResultRequest testResultRequest) throws StudentDoesNotExistException,
            TestResultDoesNotExistException {

        StudentEntity studentEntity = studentRepository.findById(testResultRequest.getStudentId())
                .orElseThrow(() -> new StudentDoesNotExistException("Student does not exist"));

        TestResultEntity testResult = studentEntity.getTestResults().stream()
                .filter(testResultEntity -> testResultRequest.getSubject()
                        .equals(testResultEntity.getSchoolTestEntity().getSubject()))
                .filter(testResultEntity -> testResultRequest.getDate()
                        .equals(testResultEntity.getSchoolTestEntity().getDate()))
                .findFirst()
                .orElseThrow(() -> new TestResultDoesNotExistException("Test result does not exist"));

        return TestResultResponse.builder()
                .studentId(testResult.getStudentEntity().getId())
                .date(testResult.getSchoolTestEntity().getDate())
                .subject(testResult.getSchoolTestEntity().getSubject())
                .grade(testResult.getGrade())
                .build();
    }

    public AverageResponse getAverage(AverageRequest averageRequest) {
        StudentEntity studentEntity = studentRepository.findById(averageRequest.getStudentId())
                .orElseThrow(IllegalArgumentException::new);

        List<Integer> grades = studentEntity.getTestResults().stream()
                .filter(testResultEntity -> averageRequest.getSubject()
                        .equals(testResultEntity.getSchoolTestEntity().getSubject()))
                .map(testResultEntity -> testResultEntity.getGrade().getValue())
                .toList();

        Double average = grades.stream()
                .mapToDouble(grade -> grade)
                .average()
                .orElseThrow(IllegalArgumentException::new);

        return AverageResponse.builder()
                .studentId(studentEntity.getId())
                .subject(averageRequest.getSubject())
                .average(average)
                .build();
    }

    public void updateTestResult(TestResultDto testResultDto) {
        TestResultEntity testResultEntity = testResultRepository.findById(testResultDto.getId())
                .orElseThrow(IllegalArgumentException::new);
        testResultEntity.setGrade(testResultDto.getGrade());
        testResultRepository.save(testResultEntity);
    }

    public TestResultDto getTestResultById(String id) {
        TestResultEntity testResultEntity = testResultRepository.findById(id).orElseThrow(NullPointerException::new);
        return testResultConverter.convertToDto(testResultEntity);
    }
}
