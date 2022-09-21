package com.example.school.entity;

import com.example.school.converter.ListOfSubjectsToStringConverter;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString(exclude = {"schoolClassEntity", "tests"})
@Entity
@Table(name = "TEACHERS")
@Builder
public class TeacherEntity {

    @Id
    private String id;

    private String name;
    private String surname;

    @Enumerated(EnumType.STRING)
    private TeacherProfile teacherProfile;

    @OneToOne
    @JoinColumn(name = "class_id")
    private SchoolClassEntity schoolClassEntity;

    @Convert(converter = ListOfSubjectsToStringConverter.class)
    @Column(name = "subjects")
    private List<Subject> subjects;

    @OneToMany(mappedBy = "teacherEntity")
    private List<SchoolTestEntity> tests = new ArrayList<>();
}
