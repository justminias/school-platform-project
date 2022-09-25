package com.example.school.controller;

import com.example.school.SchoolProjectIntegrationTest;
import com.example.school.dto.SchoolTestDto;
import com.example.school.dto.TeacherDto;
import com.example.school.entity.Subject;
import com.example.school.entity.TeacherProfile;
import com.example.school.service.SchoolTestService;
import com.example.school.service.TeacherService;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.time.LocalDate;
import java.util.List;

@SchoolProjectIntegrationTest
public class SchoolTestControllerTest {

    @Autowired
    SchoolTestService schoolTestService;

    @Autowired
    TeacherService teacherService;

    @LocalServerPort
    private int port;

    @BeforeEach
    public void setUp() {
        RestAssured.port = port;
    }

    @Test
    public void shouldAddTestToDatabase() {
        //given
        TeacherDto teacherDto = TeacherDto.builder()
                .id("1")
                .name("Name1")
                .surname("Surname1")
                .teacherProfile(TeacherProfile.SUBJECT_TEACHER)
                .classId(null)
                .subjects(List.of(Subject.FRENCH))
                .build();
        teacherService.addTeacher(teacherDto);

        //when
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
