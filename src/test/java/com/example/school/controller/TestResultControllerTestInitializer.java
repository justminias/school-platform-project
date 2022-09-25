package com.example.school.controller;

import com.example.school.dto.*;
import com.example.school.entity.Grade;
import com.example.school.entity.SchoolGradeLevel;
import com.example.school.entity.Subject;
import com.example.school.entity.TeacherProfile;
import com.example.school.service.*;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@Component
public class TestResultControllerTestInitializer {

    @Autowired
    TestResultService testResultService;

    @Autowired
    StudentService studentService;

    @Autowired
    SchoolTestService schoolTestService;

    @Autowired
    TeacherService teacherService;

    @Autowired
    SchoolClassService schoolClassService;

    void shouldAddTestResultInitializeData() {
        TeacherDto teacherDto = TeacherDto.builder()
                .id("1")
                .name("Name1")
                .surname("Surname1")
                .teacherProfile(TeacherProfile.SUBJECT_TEACHER)
                .classId(null)
                .subjects(List.of(Subject.FRENCH))
                .build();
        teacherService.addTeacher(teacherDto);

        SchoolTestDto schoolTestDto = SchoolTestDto.builder()
                .id("1")
                .date(LocalDate.of(2020, 12, 12))
                .teacherId("1")
                .subject(Subject.FRENCH)
                .build();
        schoolTestService.addSchoolTest(schoolTestDto);

        SchoolClassDto schoolClassdto = SchoolClassDto.builder()
                .id("1")
                .schoolGradeLevel(SchoolGradeLevel.SENIOR)
                .build();
        schoolClassService.addSchoolClass(schoolClassdto);

        StudentDto studentDto = StudentDto.builder()
                .id("1")
                .name("Name1")
                .surname("Surname1")
                .schoolGradeLevel(SchoolGradeLevel.SENIOR)
                .build();
        studentService.addStudent(studentDto);
    }

    void shouldReturnTestResultByTestResultRequestInitializeData() {
        TeacherDto teacherDto = TeacherDto.builder()
                .id("2")
                .name("Name2")
                .surname("Surname2")
                .teacherProfile(TeacherProfile.SUBJECT_TEACHER)
                .classId(null)
                .subjects(List.of(Subject.FRENCH))
                .build();
        teacherService.addTeacher(teacherDto);

        SchoolTestDto schoolTestDto = SchoolTestDto.builder()
                .id("2")
                .date(LocalDate.of(2020, 12, 12))
                .teacherId("2")
                .subject(Subject.FRENCH)
                .build();
        schoolTestService.addSchoolTest(schoolTestDto);

        StudentDto studentDto = StudentDto.builder()
                .id("2")
                .name("Name2")
                .surname("Surname2")
                .schoolGradeLevel(SchoolGradeLevel.SENIOR)
                .build();
        studentService.addStudent(studentDto);

        TestResultDto testResultDto = TestResultDto.builder()
                .id("2")
                .testId("2")
                .studentId("2")
                .grade(Grade.A)
                .build();
        testResultService.addTestResult(testResultDto);
    }

    void shouldReturnGradeAverageInitializeData() {
        TeacherDto teacherDto = TeacherDto.builder()
                .id("3")
                .name("Name3")
                .surname("Surname3")
                .teacherProfile(TeacherProfile.SUBJECT_TEACHER)
                .classId(null)
                .subjects(List.of(Subject.FRENCH))
                .build();
        teacherService.addTeacher(teacherDto);

        SchoolTestDto schoolTestDto1 = SchoolTestDto.builder()
                .id("3")
                .date(LocalDate.of(2020, 12, 12))
                .teacherId("3")
                .subject(Subject.FRENCH)
                .build();
        schoolTestService.addSchoolTest(schoolTestDto1);

        SchoolTestDto schoolTestDto2 = SchoolTestDto.builder()
                .id("4")
                .date(LocalDate.of(2020, 12, 12))
                .teacherId("3")
                .subject(Subject.FRENCH)
                .build();
        schoolTestService.addSchoolTest(schoolTestDto2);

        StudentDto studentDto = StudentDto.builder()
                .id("3")
                .name("Name3")
                .surname("Surname3")
                .schoolGradeLevel(SchoolGradeLevel.SENIOR)
                .build();
        studentService.addStudent(studentDto);

        TestResultDto testResultDto1 = TestResultDto.builder()
                .id("3")
                .testId("3")
                .studentId("3")
                .grade(Grade.A)
                .build();
        testResultService.addTestResult(testResultDto1);

        TestResultDto testResultDto2 = TestResultDto.builder()
                .id("4")
                .testId("4")
                .studentId("3")
                .grade(Grade.C)
                .build();
        testResultService.addTestResult(testResultDto2);
    }

    void shouldUpdateTestResultInitializeData() {

        TeacherDto teacherDto = TeacherDto.builder()
                .id("3")
                .name("Name3")
                .surname("Surname3")
                .teacherProfile(TeacherProfile.SUBJECT_TEACHER)
                .classId(null)
                .subjects(List.of(Subject.FRENCH))
                .build();
        teacherService.addTeacher(teacherDto);

        SchoolTestDto schoolTestDto1 = SchoolTestDto.builder()
                .id("1")
                .date(LocalDate.of(2020, 12, 12))
                .teacherId("3")
                .subject(Subject.FRENCH)
                .build();
        schoolTestService.addSchoolTest(schoolTestDto1);

        StudentDto studentDto = StudentDto.builder()
                .id("1")
                .name("Name3")
                .surname("Surname3")
                .schoolGradeLevel(SchoolGradeLevel.SENIOR)
                .build();
        studentService.addStudent(studentDto);

        TestResultDto testResultDto = TestResultDto.builder()
                .id("1")
                .testId("1")
                .studentId("1")
                .grade(Grade.A)
                .build();

        testResultService.addTestResult(testResultDto);
    }
}
