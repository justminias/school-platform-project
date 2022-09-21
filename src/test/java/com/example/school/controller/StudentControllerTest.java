package com.example.school.controller;

import com.example.school.SchoolProjectIntegrationTest;
import com.example.school.dto.StudentDto;
import com.example.school.entity.SchoolGradeLevel;
import com.example.school.service.StudentService;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.server.LocalServerPort;

@SchoolProjectIntegrationTest
public class StudentControllerTest {

    @Autowired
    StudentService studentService;

    @LocalServerPort
    private int port;

    @BeforeEach
    public void setUp() {
        RestAssured.port = port;
    }

    @Test
    public void shouldAddStudentToDatabase() {
        //given when
        RestAssured.given()
                .contentType(ContentType.JSON)
                .body(StudentDto.builder()
                        .id("1")
                        .name("Name1")
                        .surname("Surname1")
                        .schoolGradeLevel(SchoolGradeLevel.SENIOR)
                        .build())
                .when()
                .post("/student/add")
                .then()
                .statusCode(200);

        //then
        StudentDto result = studentService.getStudent("1");
        Assertions.assertEquals(StudentDto.builder()
                .id("1")
                .name("Name1")
                .surname("Surname1")
                .schoolGradeLevel(SchoolGradeLevel.SENIOR)
                .build(), result);
    }
}
