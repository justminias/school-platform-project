package com.example.school.dto;

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
public class TestResultRequest {

    private String studentId;
    private LocalDate date;
    private Subject subject;
}
