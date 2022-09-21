package com.example.school.dto;

import com.example.school.entity.Subject;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SchoolTestDto implements Dto {

    private String id;
    private LocalDate date;
    private String teacherId;
    private Subject subject;
}
