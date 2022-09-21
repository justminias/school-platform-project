package com.example.school.dto;

import com.example.school.entity.Subject;
import lombok.*;

@AllArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
@Builder
public class AverageResponse {

    private String studentId;
    private Subject subject;
    private Double average;
}
