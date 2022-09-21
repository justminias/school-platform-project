package com.example.school.repository;

import com.example.school.entity.SchoolTestEntity;
import com.example.school.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface SchoolTestRepository extends JpaRepository<SchoolTestEntity, String> {
}
