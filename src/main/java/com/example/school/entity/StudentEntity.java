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
@ToString(exclude = {"schoolClassEntity", "testResults"})
@Entity
@Table(name = "STUDENTS")
@Builder
public class StudentEntity {

    @Id
    private String id;

    private String name;
    private String surname;

    @ManyToOne
    @JoinColumn(name = "class_id")
    private SchoolClassEntity schoolClassEntity;

    @OneToMany(mappedBy = "studentEntity")
    private List<TestResultEntity> testResults = new ArrayList<>();
}
