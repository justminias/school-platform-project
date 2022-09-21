package com.example.school.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString(exclude = "students")
@Entity
@Table(name = "CLASSES")
@Builder
public class SchoolClassEntity {

    @Id
    private String id;

    @Column(unique = true)
    @Enumerated(EnumType.STRING)
    private SchoolGradeLevel schoolGradeLevel;

    @OneToOne
    @JoinColumn(name = "teacher_id")
    private TeacherEntity teacherEntity;

    @OneToMany(mappedBy = "schoolClassEntity")
    private List<StudentEntity> students = new ArrayList<>();
}
