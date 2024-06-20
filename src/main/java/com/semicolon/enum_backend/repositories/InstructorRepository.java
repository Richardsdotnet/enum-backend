package com.semicolon.enum_backend.repositories;

import com.semicolon.enum_backend.models.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorRepository extends JpaRepository<Instructor, Long> {
}
