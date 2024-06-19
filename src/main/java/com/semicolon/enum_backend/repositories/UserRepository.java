package com.semicolon.enum_backend.repositories;

import com.semicolon.enum_backend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
