package com.example.school.controller;

import com.example.school.SchoolProjectIntegrationTest;
import com.example.school.dto.SchoolClassDto;
import com.example.school.entity.SchoolGradeLevel;
import com.example.school.service.SchoolClassService;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.server.LocalServerPort;

@SchoolProjectIntegrationTest
public class SchoolClassControllerTest {

    @Autowired
    SchoolClassService schoolClassService;

    @LocalServerPort
    private int port;

    @BeforeEach
    public void setUp() {
        RestAssured.port = port;
    }

    @Test
    public void shouldAddSchoolClassToDatabase() {
        //given when
        RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(SchoolClassDto.builder()
                        .id("1")
                        .schoolGradeLevel(SchoolGradeLevel.SENIOR)
                        .build())
                .when()
                .post("/class/add")
                .then()
                .statusCode(200);

        //then
        SchoolClassDto result = schoolClassService.getSchoolClass("1");
        Assertions.assertEquals(SchoolClassDto.builder()
                .id("1")
                .schoolGradeLevel(SchoolGradeLevel.SENIOR)
                .build(), result);
    }
}
