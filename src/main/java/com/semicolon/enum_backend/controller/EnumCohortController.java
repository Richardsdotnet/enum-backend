package com.semicolon.enum_backend.controller;

import com.semicolon.enum_backend.dto.request.CreateCohortRequest;
import com.semicolon.enum_backend.dto.response.CreateCohortResponse;
import com.semicolon.enum_backend.exceptions.CohortNotFoundException;
import com.semicolon.enum_backend.exceptions.EnumException;
import com.semicolon.enum_backend.models.Cohort;
import com.semicolon.enum_backend.services.CohortService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class EnumCohortController {

    private final CohortService cohortService;

    @PostMapping("/create")
    public ResponseEntity<CreateCohortResponse> createCohort(@RequestBody CreateCohortRequest createCohortRequest) {
        try {
            return new ResponseEntity<>(cohortService.createCohort(createCohortRequest), HttpStatus.CREATED);
        } catch (EnumException exception) {
            return new ResponseEntity<>(new CreateCohortResponse(exception.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findCohortById/{id}")
    public ResponseEntity<Cohort> findCohortById(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(cohortService.findCohortById(id), HttpStatus.FOUND);
        } catch (CohortNotFoundException exception) {
            return new ResponseEntity<>(new Cohort(exception.getMessage()), HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("findAllCohorts")
    public ResponseEntity<List<Cohort>> findAllCohorts() {
        Optional<List<Cohort>> optionalCohorts = cohortService.findAllCohorts();
        return optionalCohorts
                .map(cohorts -> new ResponseEntity<>(cohorts, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @GetMapping("deleteCohortById/{id}")

    public ResponseEntity<Cohort> deleteCohortById(@PathVariable Long id) {
        try{
            cohortService.deleteCohortById(id);
            return  new ResponseEntity<>(new Cohort(), HttpStatus.OK);
        }catch (CohortNotFoundException exception){
        return  new ResponseEntity<>(new Cohort(exception.getMessage()), HttpStatus.NOT_FOUND);
        }
    }

}











