package com.example.school.dto;

import com.example.school.entity.Subject;
import com.example.school.entity.TeacherProfile;
import lombok.*;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TeacherDto implements Dto {

    private String id;
    private String name;
    private String surname;
    private TeacherProfile teacherProfile;
    private String classId;
    private List<Subject> subjects;
}
