package com.tracker.application.job.service.impl;

import com.jat.model.AddApplicationResponse;
import com.jat.model.JobApplicationDetailsModel;
import com.jat.model.JobApplicationModel;
import com.tracker.application.job.exception.JATException;
import com.tracker.application.job.model.JobApplication;
import com.tracker.application.job.model.User;
import com.tracker.application.job.model.enums.JATError;
import com.tracker.application.job.repository.JatIdRepository;
import com.tracker.application.job.repository.JobApplicationRepository;
import com.tracker.application.job.repository.UserRepository;
import com.tracker.application.job.service.JobApplicationService;
import com.tracker.application.job.utility.JatUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JobApplicationServiceImpl implements JobApplicationService {

    @Autowired
    private JatIdRepository jatIdRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JobApplicationRepository jobApplicationRepository;

    @Override
    public AddApplicationResponse addApplication(JobApplication jobApplication) {
        // check if user exits for given email id
        Optional<User> optionalUser = this.userRepository.findById(jobApplication.getEmailId());
        if (optionalUser.isEmpty()) {
            throw new JATException(JATError.USER_NOT_FOUND);
        }

        // create new jat id
        String jatId = this.jatIdRepository.createJatId();

        // set additional fields
        jobApplication.setJatId(jatId);
        jobApplication.setCreationDate(OffsetDateTime.now());
        jobApplication.setLastEdited(OffsetDateTime.now());
        jobApplication.setLastChecked(OffsetDateTime.now());

        // save in db
        this.saveJobApplication(jobApplication);

        // returning response
        return new AddApplicationResponse().jatId(jatId);
    }

    @Transactional
    private void saveJobApplication(JobApplication jobApplication) {
        this.jobApplicationRepository.save(jobApplication);
    }

    @Override
    public List<JobApplicationModel> getApplications(String emailId) {
        // check if user exits for given email id
        Optional<User> optionalUser = this.userRepository.findById(emailId);
        // throwing exception if User is Not Found
        if (optionalUser.isEmpty()) {
            throw new JATException(JATError.USER_NOT_FOUND);
        }

        // fetching job applications using email id
        List<JobApplication> jobApplications = this.jobApplicationRepository.findByEmailId(emailId);

        // building job application model list and returning
        return jobApplications.stream().map((jobApplication) -> JatUtility.map(jobApplication)).collect(Collectors.toList());
    }

    @Override
    public JobApplicationDetailsModel getApplicationDetails(String jatId) {
        // fetching job application based on JAT ID
        Optional<JobApplication> optional = this.jobApplicationRepository.findById(jatId);
        // throwing exception if job application is Not Found
        if (optional.isEmpty()) {
            throw new JATException(JATError.JOB_APPLICATION_NOT_FOUND);
        }
        // returning the job application details
        return JatUtility.mapToApplicationDetailsModel(optional.get());
    }

}
