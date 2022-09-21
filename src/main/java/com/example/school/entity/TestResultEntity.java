package com.example.school.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "TEST_RESULTS")
@Builder
public class TestResultEntity {

    @Id
    private String id;

    @ManyToOne
    @JoinColumn(name = "test_id")
    private SchoolTestEntity schoolTestEntity;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private StudentEntity studentEntity;

    @Enumerated(EnumType.STRING)
    private Grade grade;
}
