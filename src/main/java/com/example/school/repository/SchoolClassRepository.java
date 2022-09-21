package com.example.school.repository;

import com.example.school.entity.SchoolClassEntity;
import com.example.school.entity.SchoolGradeLevel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolClassRepository extends JpaRepository<SchoolClassEntity, String> {

    SchoolClassEntity findBySchoolGradeLevel(SchoolGradeLevel schoolGradeLevel);
}
