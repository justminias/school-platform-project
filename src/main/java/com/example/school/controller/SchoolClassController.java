package com.example.school.controller;

import com.example.school.dto.SchoolClassDto;
import com.example.school.service.SchoolClassService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/class")
public class SchoolClassController {

    private final SchoolClassService schoolClassService;

    @PostMapping("/add")
    public void addSchoolClass(@RequestBody SchoolClassDto schoolClassDto) {
        schoolClassService.addSchoolClass(schoolClassDto);
    }
}
