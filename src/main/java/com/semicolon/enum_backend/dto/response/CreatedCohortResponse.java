package com.semicolon.enum_backend.dto.response;

import com.semicolon.enum_backend.models.Cohort;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreatedCohortResponse {
    private String message;
    private Cohort cohort;
}
