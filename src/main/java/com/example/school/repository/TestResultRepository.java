package com.example.school.repository;

import com.example.school.entity.TestResultEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestResultRepository extends JpaRepository<TestResultEntity, String> {
}
