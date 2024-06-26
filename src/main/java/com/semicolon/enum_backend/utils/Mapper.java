package com.semicolon.enum_backend.utils;

import com.semicolon.enum_backend.dto.request.CreateCohortRequest;
import com.semicolon.enum_backend.dto.request.CreateCourseRequest;
import com.semicolon.enum_backend.dto.request.RegisterOrganizationRequest;
import com.semicolon.enum_backend.dto.request.RegisterUserRequest;
import com.semicolon.enum_backend.exceptions.CohortNotFoundException;
import com.semicolon.enum_backend.models.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component

public class Mapper {

        public User mapUserRegistration(RegisterUserRequest request){
            User user = new User();
            user.setFirstName(request.getFirstName());
            user.setFirstName(request.getFirstName());
            user.setEmail(request.getEmail());
            user.setRole(request.getRole());
            user.setPassword(request.getPassword());
            return user;
        }


        public Cohort mapCohort(CreateCohortRequest createCohortRequest) {
            Cohort newCohort = new Cohort();
            newCohort.setAvatar(createCohortRequest.getAvatar());
            newCohort.setDescription(createCohortRequest.getDescription());
            newCohort.setName(createCohortRequest.getName());
            newCohort.setStartDate(createCohortRequest.getStartDate());
            newCohort.setEndDate(createCohortRequest.getEndDate());
            newCohort.setProgram(Program.valueOf(createCohortRequest.getProgram()));

//            newCohort.setOrganization(createCohortRequest.getOrganization());
            return newCohort;
        }



        private static String getEncryptedPassword(RegisterUserRequest request) {
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            return encoder.encode(request.getPassword());
        }
        public Course mapCourse(CreateCourseRequest createCourseRequest) throws CohortNotFoundException {
            Course course = new Course();
            course.setName(createCourseRequest.getName());
            return course;
        }

//        public Organization mapOrganisation(RegisterOrganizationRequest registerOrganizationRequest) {
//            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//            String encodedPassword = passwordEncoder.encode(registerOrganizationRequest.getPassword());
//
//            Organization organization = new Organization();
//            organization.setName(registerOrganizationRequest.getName());
//            organization.setCac(registerOrganizationRequest.getCac());
//            organization.setEmail(registerOrganizationRequest.getEmail());
//            organization.setPassword(encodedPassword);
//            organization.setRole(Role.ORGANIZATION);
//
//            return organization;
//        }

//        public Instructor mapInstructor(RegisterUserRequest registerInstructor) {
//            Instructor instructor = new Instructor();
//            instructor.setFirstName(registerInstructor.getFirstName());
//            instructor.setLastName(registerInstructor.getLastName());
//            instructor.setEmail(registerInstructor.getEmail());
//            String encodedPassword = getEncryptedPassword(registerInstructor);
//            instructor.setPassword(encodedPassword);
//            instructor.setRole(registerInstructor.getRole());
//            instructor.setOrganizationId(registerInstructor.getOrganizationId());
//            instructor.setDateAdded(LocalDate.now());
//            instructor.setCourses(registerInstructor.getCourses());
//            instructor.setInstructorStatus(Status.ACTIVE);
//            return instructor;
//        }

        public User mapLearner(RegisterUserRequest registerLearner) {
            Learner learner = new Learner();
            learner.setFirstName(registerLearner.getFirstName());
            learner.setLastName(registerLearner.getLastName());
            learner.setEmail(registerLearner.getEmail());
            String encodedPassword = getEncryptedPassword(registerLearner);
            learner.setPassword(encodedPassword);
            learner.setRole(registerLearner.getRole());
            learner.setNoOfPrograms(0);
            learner.setOrganizationId(registerLearner.getOrganizationId());
            learner.setDateAdded(LocalDate.now());
            learner.setLearnerStatus(Status.ACTIVE);
            return learner;
        }



    private User mapAdmin(RegisterUserRequest createUserRequest) {
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

