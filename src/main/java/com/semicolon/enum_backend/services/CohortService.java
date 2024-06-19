package com.semicolon.enum_backend.services;

import com.semicolon.enum_backend.dto.request.CreateCohortRequest;
import com.semicolon.enum_backend.dto.response.CreateCohortResponse;
import com.semicolon.enum_backend.models.Cohort;

;import java.util.List;
import java.util.Optional;

public interface CohortService {
CreateCohortResponse createCohort(CreateCohortRequest createCohortRequest);
 Cohort findCohortById(Long id);
Optional<List<Cohort>> findAllCohorts();
void deleteCohortById(Long id);
}
