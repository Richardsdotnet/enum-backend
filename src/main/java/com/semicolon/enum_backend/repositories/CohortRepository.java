package com.semicolon.enum_backend.repositories;

import com.semicolon.enum_backend.models.Cohort;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CohortRepository extends JpaRepository <Cohort, Long> {

}
