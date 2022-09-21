package com.example.school.controller;

import com.example.school.dto.SchoolTestDto;
import com.example.school.service.SchoolTestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/test")
public class SchoolTestController {

    private final SchoolTestService schoolTestService;

    @PostMapping("/add")
    public void addSchoolTest(@RequestBody SchoolTestDto schoolTestDto) {
        schoolTestService.addSchoolTest(schoolTestDto);
    }
}
