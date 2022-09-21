package com.example.school.helper;

import com.example.school.dto.*;
import com.example.school.entity.StudentDoesNotExistException;
import com.example.school.entity.TestResultDoesNotExistException;
import com.example.school.service.TestResultService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class TestResultHelper {

    private final TestResultService testResultService;

    public void addTestResult(TestResultDto testResultDto) {
        testResultService.addTestResult(testResultDto);
    }

    public TestResultResponse getTestResult(TestResultRequest testResultRequest) {
        try {
            return testResultService.getTestResult(testResultRequest);
        } catch (StudentDoesNotExistException studentDoesNotExistException) {
            log.warn("User with id: {} does not exist.", testResultRequest.getStudentId());
        } catch (TestResultDoesNotExistException testResultDoesNotExistException) {
            log.warn("Test result does not exist.");
        }
        return null;
    }

    public AverageResponse getAverage(AverageRequest averageRequest) {
        return testResultService.getAverage(averageRequest);
    }

    public void updateTestResult(TestResultDto testResultDto) {
        testResultService.updateTestResult(testResultDto);
    }
}
