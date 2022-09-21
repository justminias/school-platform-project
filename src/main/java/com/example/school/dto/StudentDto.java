package com.example.school.dto;

import com.example.school.entity.SchoolGradeLevel;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentDto implements Dto {

    private String id;
    private String name;
    private String surname;
    private SchoolGradeLevel schoolGradeLevel;
}
