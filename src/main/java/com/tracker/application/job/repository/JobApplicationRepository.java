package com.tracker.application.job.repository;

import com.tracker.application.job.model.JobApplication;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface JobApplicationRepository extends MongoRepository<JobApplication, String> {

    List<JobApplication> findByEmailId(String emailId);

}
