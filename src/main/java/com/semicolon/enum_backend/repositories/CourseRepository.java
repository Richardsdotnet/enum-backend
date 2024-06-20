package com.semicolon.enum_backend.repositories;

import com.semicolon.enum_backend.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
