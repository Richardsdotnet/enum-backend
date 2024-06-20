package com.semicolon.enum_backend.utils;

import com.semicolon.enum_backend.dto.request.*;
import com.semicolon.enum_backend.dto.response.CreatedCohortResponse;
import com.semicolon.enum_backend.exceptions.CohortNotFoundException;
import com.semicolon.enum_backend.models.*;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component

public class Mapper {


        public Cohort map(CreateCohortRequest createCohortRequest) {
            Cohort newCohort = new Cohort();
            newCohort.setAvatar(createCohortRequest.getAvatar());
            newCohort.setDescription(createCohortRequest.getDescription());
            newCohort.setName(createCohortRequest.getName());
            newCohort.setStartDate(createCohortRequest.getStartDate());
            newCohort.setEndDate(createCohortRequest.getEndDate());

            newCohort.setProgramType(createCohortRequest.getProgramType());
            newCohort.setOrganization(createCohortRequest.getOrganization());
            return newCohort;
        }


        public CreatedCohortResponse map(Cohort savedCohort) {
            CreatedCohortResponse createdCohortResponse = new CreatedCohortResponse();
            createdCohortResponse.setCohort(savedCohort);
            createdCohortResponse.setMessage("Cohort Created Successfully");
            return createdCohortResponse;
        }
        public User map(RegisterUserRequest registerUserRequest) {
            User user = new User();
            user.setFirstName(registerUserRequest.getFirstName());
            user.setLastName(registerUserRequest.getLastName());
            user.setEmail(registerUserRequest.getEmail());
            String encodedPassword = getEncryptedPassword(registerUserRequest);
            user.setPassword(encodedPassword);
            user.setRole(registerUserRequest.getRole());
            return user;
        }
        private static String getEncryptedPassword(RegisterUserRequest request) {
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            return encoder.encode(request.getPassword());
        }
        public Course map(CreateCourseRequest createCourseRequest) throws CohortNotFoundException {
            Course course = new Course();
            course.setName(createCourseRequest.getName());
            return course;
        }

        public Organization map(RegisterOrganizationRequest registerOrganizationRequest) {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String encodedPassword = passwordEncoder.encode(registerOrganizationRequest.getPassword());

            Organization organization = new Organization();
            organization.setName(registerOrganizationRequest.getName());
            organization.setCac(registerOrganizationRequest.getCac());
            organization.setEmail(registerOrganizationRequest.getEmail());
            organization.setPassword(encodedPassword);
            organization.setRole(Role.ORGANIZATION);

            return organization;
        }

        public Instructor mapInstructor(RegisterUserRequest createUserRequest) {
            Instructor user = new Instructor();
            user.setFirstName(createUserRequest.getFirstName());
            user.setLastName(createUserRequest.getLastName());
            user.setEmail(createUserRequest.getEmail());
            String encodedPassword = getEncryptedPassword(createUserRequest);
            user.setPassword(encodedPassword);
            user.setRole(createUserRequest.getRole());
            user.setOrganizationId(createUserRequest.getOrganizationId());
            user.setDateAdded(LocalDate.now());
            user.setCourses(createUserRequest.getCourses());
            user.setInstructorStatus(Status.ACTIVE);
            return user;
        }

        public User mapLearner(RegisterUserRequest createUserRequest) {
            Learner user = new Learner();
            user.setFirstName(createUserRequest.getFirstName());
            user.setLastName(createUserRequest.getLastName());
            user.setEmail(createUserRequest.getEmail());
            String encodedPassword = getEncryptedPassword(createUserRequest);
            user.setPassword(encodedPassword);
            user.setRole(createUserRequest.getRole());
            user.setNoOfPrograms(0);
            user.setOrganizationId(createUserRequest.getOrganizationId());
            user.setDateAdded(LocalDate.now());
            user.setLearnerStatus(Status.ACTIVE);
            return user;
        }

        public User mapAdmin(RegisterUserRequest createUserRequest) {
            User admin = new User();
            admin.setFirstName(createUserRequest.getFirstName());
            admin.setLastName(createUserRequest.getLastName());
            admin.setEmail(createUserRequest.getEmail());
            String encodedPassword = getEncryptedPassword(createUserRequest);
            admin.setPassword(encodedPassword);
            admin.setRole(createUserRequest.getRole());
            return admin;
        }
    }
}
