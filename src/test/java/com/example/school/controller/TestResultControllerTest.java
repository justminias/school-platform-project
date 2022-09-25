package com.example.school.controller;

import com.example.school.SchoolProjectIntegrationTest;
import com.example.school.dto.*;
import com.example.school.entity.Grade;
import com.example.school.entity.Subject;
import com.example.school.service.TestResultService;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.time.LocalDate;

@SchoolProjectIntegrationTest
public class TestResultControllerTest {

    @Autowired
    TestResultControllerTestInitializer testResultControllerTestInitializer;

    @Autowired
    TestResultService testResultService;

    @Autowired
    TestCleaner testCleaner;

    @LocalServerPort
    private int port;

    @BeforeEach
    public void setUp() {
        RestAssured.port = port;
    }

    @AfterEach
    public void tearDown() {
        testCleaner.cleanAllRepositories();
    }

    @Test
    public void shouldAddTestResult() {
        //given
        testResultControllerTestInitializer.shouldAddTestResultInitializeData();

        // when
        RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(TestResultDto.builder()
                        .id("1")
                        .testId("1")
                        .studentId("1")
                        .grade(Grade.D)
                        .build())
                .when()
                .post("/test-result/add")
                .then()
                .statusCode(200);

        //then
        TestResultDto result = testResultService.getTestResultById("1");
        Assertions.assertEquals(TestResultDto.builder()
                .id("1")
                .testId("1")
                .studentId("1")
                .grade(Grade.D)
                .build(), result);
    }

    @Test
    public void shouldReturnTestResultByTestResultRequest() {
        //given
        testResultControllerTestInitializer.shouldReturnTestResultByTestResultRequestInitializeData();

        //when
        TestResultResponse result = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(TestResultRequest.builder()
                        .studentId("2")
                        .date(LocalDate.of(2020, 12, 12))
                        .subject(Subject.FRENCH)
                        .build())
                .when()
                .post("/test-result/get")
                .then()
                .statusCode(200)
                .extract()
                .as(TestResultResponse.class);

        //then
        Assertions.assertEquals(TestResultResponse.builder()
                .studentId("2")
                .date(LocalDate.of(2020, 12, 12))
                .subject(Subject.FRENCH)
                .grade(Grade.A)
                .build(), result);
    }

    @Test
    public void shouldReturnGradeAverage() {
        //given
        testResultControllerTestInitializer.shouldReturnGradeAverageInitializeData();

        //when
        AverageResponse result = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(AverageRequest.builder()
                        .studentId("3")
                        .subject(Subject.FRENCH)
                        .build())
                .when()
                .post("/test-result/average")
                .then()
                .statusCode(200)
                .extract()
                .as(AverageResponse.class);

        //then
        Assertions.assertEquals(AverageResponse.builder()
                .studentId("3")
                .subject(Subject.FRENCH)
                .average(4.0)
                .build(), result);
    }

    @Test
    public void shouldUpdateTestResult() {
        //given
        testResultControllerTestInitializer.shouldUpdateTestResultInitializeData();

        //when
        RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(TestResultDto.builder()
                        .id("1")
                        .testId("1")
                        .studentId("1")
                        .grade(Grade.D)
                        .build())
                .when()
                .post("/test-result/update")
                .then()
                .statusCode(200);

        //then
        TestResultDto result = testResultService.getTestResultById("1");
        Assertions.assertEquals(TestResultDto.builder()
                .id("1")
                .testId("1")
                .studentId("1")
                .grade(Grade.D)
                .build(), result);

    }
}
