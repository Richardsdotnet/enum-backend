package com.semicolon.enum_backend.repositories;

import com.semicolon.enum_backend.models.ProgramType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProgramTypeRepository extends JpaRepository<ProgramType, Long> {
}
