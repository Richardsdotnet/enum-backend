package com.semicolon.enum_backend.repositories;

import com.semicolon.enum_backend.models.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganisationRepository extends JpaRepository<Organization, Long> {
}
