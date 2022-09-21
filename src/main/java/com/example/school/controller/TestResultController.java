package com.example.school.controller;

import com.example.school.dto.*;
import com.example.school.helper.TestResultHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/test-result")
public class TestResultController {

    private final TestResultHelper testResultHelper;

    @PostMapping("/add")
    public void addTestResult(@RequestBody TestResultDto testResultDto) {
        testResultHelper.addTestResult(testResultDto);
    }

    @PostMapping("/get")
    public TestResultResponse getTestResult(@RequestBody TestResultRequest testResultRequest) {
        return testResultHelper.getTestResult(testResultRequest);
    }

    @PostMapping("/average")
    public AverageResponse getAverage(@RequestBody AverageRequest averageRequest) {
        return testResultHelper.getAverage(averageRequest);
    }

    @PostMapping("/update")
    public void updateTestResult(@RequestBody TestResultDto testResultDto) {
        testResultHelper.updateTestResult(testResultDto);
    }
}
