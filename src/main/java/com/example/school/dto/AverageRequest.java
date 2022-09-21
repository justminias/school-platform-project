package com.example.school.dto;

import com.example.school.entity.Subject;
import lombok.*;

@AllArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
@Builder
public class AverageRequest {

    private String studentId;
    private Subject subject;
}
