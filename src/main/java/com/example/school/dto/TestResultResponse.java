package com.example.school.dto;

import com.example.school.entity.Grade;
import com.example.school.entity.Subject;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
public class TestResultResponse {

    private String studentId;
    private LocalDate date;
    private Subject subject;
    private Grade grade;
}
