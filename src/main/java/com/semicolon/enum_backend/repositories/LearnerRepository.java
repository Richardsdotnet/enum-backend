package com.semicolon.enum_backend.repositories;

import com.semicolon.enum_backend.models.Learner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LearnerRepository extends JpaRepository<Learner, Long> {
}
