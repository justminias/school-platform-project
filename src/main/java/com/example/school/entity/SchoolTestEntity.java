package com.example.school.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "TESTS")
@Builder
public class SchoolTestEntity {

    @Id
    private String id;
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private TeacherEntity teacherEntity;

    @Enumerated(EnumType.STRING)
    private Subject subject;

    @OneToMany(mappedBy = "schoolTestEntity")
    private List<TestResultEntity> testResults = new ArrayList<>();
}
