package com.semicolon.enum_backend.services;

import com.semicolon.enum_backend.dto.request.CreateCohortRequest;
import com.semicolon.enum_backend.dto.response.CreateCohortResponse;
import com.semicolon.enum_backend.exceptions.CohortNotFoundException;
import com.semicolon.enum_backend.exceptions.EnumException;
import com.semicolon.enum_backend.models.Cohort;
import com.semicolon.enum_backend.models.Program;
import com.semicolon.enum_backend.repositories.CohortRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class EnumCohortService implements CohortService{

    private final CohortRepository cohortRepository;
    @Override
    public CreateCohortResponse createCohort(CreateCohortRequest createCohortRequest) {
        log.info("About to validate .....");
        validateFields(createCohortRequest);
        log.info("After validation .......");

        Cohort cohort = new Cohort();
        cohort.setProgram(Program.valueOf(createCohortRequest.getProgram().toUpperCase()));
        BeanUtils.copyProperties(createCohortRequest, cohort);
        Cohort createdCohort =cohortRepository.save(cohort);

        log.info("cohort saved is ..... {}", createdCohort);
        CreateCohortResponse createCohortResponse = new CreateCohortResponse();
        createCohortResponse.setId(createdCohort.getId());
        createCohortResponse.setMessage("Cohort created successfully");

        return createCohortResponse;
    }

    @Override
    public Cohort findCohortById(Long id) {
       return cohortRepository.findById(id).orElseThrow(()-> new CohortNotFoundException("Cohort not found"));

    }

    @Override
    public Optional<List<Cohort>> findAllCohorts() {
        List<Cohort> cohorts = cohortRepository.findAll();
        if(cohorts.isEmpty()){
            throw new CohortNotFoundException("Cohorts not Found");
        }else {
            return Optional.of(cohorts);
        }
    }


    private void validateFields(CreateCohortRequest createCohortRequest) {
        try{
            Program.valueOf(createCohortRequest.getProgram().toUpperCase());
        }catch (IllegalArgumentException illegalArgumentException){
            throw new EnumException(createCohortRequest.getProgram() + " does not exist as a program");
        }
    }

    public void deleteCohortById(Long id){
        cohortRepository.findById(id).ifPresentOrElse(cohortRepository::delete,
                () -> { throw new CohortNotFoundException("Cohort with id " + id + " does not exist"); }
                );
    }

}
