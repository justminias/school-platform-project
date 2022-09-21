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
public class SchoolClassDto implements Dto {

    private String id;

//    @EnumValid(regexp = "(?=^\\S+$)(?=FRESHMAN)")
    private SchoolGradeLevel schoolGradeLevel;
}
