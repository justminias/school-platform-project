package com.example.school.controller;

import com.example.school.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class TestCleaner {

    @Autowired
    SchoolClassRepository schoolClassRepository;

    @Autowired
    SchoolTestRepository schoolTestRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    TestResultRepository testResultRepository;

    public void cleanAllRepositories() {
        testResultRepository.deleteAll();
        schoolTestRepository.deleteAll();
        studentRepository.deleteAll();
        teacherRepository.deleteAll();
        schoolClassRepository.deleteAll();
    }
}
