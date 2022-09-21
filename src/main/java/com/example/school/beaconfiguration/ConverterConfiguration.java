package com.example.school.beaconfiguration;

import com.example.school.converter.*;
import com.example.school.repository.SchoolClassRepository;
import com.example.school.repository.SchoolTestRepository;
import com.example.school.repository.StudentRepository;
import com.example.school.repository.TeacherRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConverterConfiguration {

    @Bean
    public StudentConverter studentConverter(SchoolClassRepository schoolClassRepository) {
        return new StudentConverter(schoolClassRepository);
    }

    @Bean
    public SchoolClassConverter schoolClassConverter() {
        return new SchoolClassConverter();
    }

    @Bean
    public SchoolTestConverter schoolTestConverter(TeacherRepository teacherRepository) {
        return new SchoolTestConverter(teacherRepository);
    }

    @Bean
    public ListOfSubjectsToStringConverter listOfSubjectsToStringConverter() {
        return new ListOfSubjectsToStringConverter();
    }

    @Bean
    public TeacherConverter teacherConverter() {
        return new TeacherConverter();
    }

    @Bean
    public TestResultConverter testResultConverter(SchoolTestRepository schoolTestRepository, StudentRepository studentRepository) {
        return new TestResultConverter(schoolTestRepository, studentRepository);
    }
}
