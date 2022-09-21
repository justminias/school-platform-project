package com.example.school.beaconfiguration;

import com.example.school.converter.*;
import com.example.school.repository.*;
import com.example.school.service.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfiguration {

    @Bean
    public SchoolClassService schoolClassService(SchoolClassRepository schoolClassRepository, SchoolClassConverter schoolClassConverter) {
        return new SchoolClassService(schoolClassRepository, schoolClassConverter);
    }

    @Bean
    public SchoolTestService schoolTestService(SchoolTestRepository schoolTestRepository, SchoolTestConverter schoolTestConverter) {
        return new SchoolTestService(schoolTestRepository, schoolTestConverter);
    }

    @Bean
    public StudentService studentService(StudentRepository studentRepository, StudentConverter studentConverter) {
        return new StudentService(studentRepository, studentConverter);
    }

    @Bean
    public TeacherService teacherService(TeacherRepository teacherRepository, TeacherConverter teacherConverter) {
        return new TeacherService(teacherRepository, teacherConverter);
    }

    @Bean
    public TestResultService testResultService(TestResultRepository testResultRepository,
                                               TestResultConverter testResultConverter, StudentRepository studentRepository) {
        return new TestResultService(testResultRepository, testResultConverter, studentRepository);
    }
}
