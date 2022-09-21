package com.example.school.controller;

import com.example.school.SchoolProjectIntegrationTest;
import com.example.school.dto.SchoolTestDto;
import com.example.school.entity.Subject;
import com.example.school.service.SchoolTestService;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.time.LocalDate;

@SchoolProjectIntegrationTest
public class SchoolTestControllerTest {

    @Autowired
    SchoolTestService schoolTestService;

    @LocalServerPort
    private int port;

    @BeforeEach
    public void setUp() {
        RestAssured.port = port;
    }

    @Test
    public void shouldAddTestToDatabase() {
        //given when
        RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(SchoolTestDto.builder()
                        .id("1")
                        .date(LocalDate.of(2020, 12, 12))
                        .teacherId("1")
                        .subject(Subject.FRENCH)
                        .build())
                .when()
                .post("/test/add")
                .then()
                .statusCode(200);

        //then
        SchoolTestDto result = schoolTestService.getSchoolTest("1");
        Assertions.assertEquals(SchoolTestDto.builder()
                .id("1")
                .date(LocalDate.of(2020, 12, 12))
                .teacherId("1")
                .subject(Subject.FRENCH)
                .build(), result);
    }
}
