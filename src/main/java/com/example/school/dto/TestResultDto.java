package com.example.school.dto;

import com.example.school.entity.Grade;
import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TestResultDto implements Dto {

    private String id;
    private String testId;
    private String studentId;
    private Grade grade;
}
