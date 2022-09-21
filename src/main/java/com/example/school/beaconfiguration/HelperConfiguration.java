package com.example.school.beaconfiguration;

import com.example.school.helper.TestResultHelper;
import com.example.school.service.TestResultService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelperConfiguration {

    @Bean
    public TestResultHelper testResultHelper(TestResultService testResultService) {
        return new TestResultHelper(testResultService);
    }
}
