package com.example.school.controller;

import com.example.school.SchoolProjectIntegrationTest;
import com.example.school.dto.TeacherDto;
import com.example.school.entity.Subject;
import com.example.school.entity.TeacherProfile;
import com.example.school.service.TeacherService;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.util.List;

@SchoolProjectIntegrationTest
public class TeacherControllerTest {

    @Autowired
    TeacherService teacherService;

    @LocalServerPort
    private int port;

    @BeforeEach
    public void setUp() {
        RestAssured.port = port;
    }

    @Test
    public void shouldAddTeacherToDatabase() {
        //given when
        RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(TeacherDto.builder()
                        .id("1")
                        .name("Name1")
                        .surname("Surname1")
                        .teacherProfile(TeacherProfile.SUBJECT_TEACHER)
                        .classId(null)
                        .subjects(List.of(Subject.BIOLOGY, Subject.CHEMISTRY))
                        .build())
                .when()
                .post("/teacher/add")
                .then()
                .statusCode(200);

        //then
        TeacherDto result = teacherService.getTeacher("1");
        Assertions.assertEquals(TeacherDto.builder()
                .id("1")
                .name("Name1")
                .surname("Surname1")
                .teacherProfile(TeacherProfile.SUBJECT_TEACHER)
                .classId(null)
                .subjects(List.of(Subject.BIOLOGY, Subject.CHEMISTRY))
                .build(), result);
    }
}
