package com.tracker.application.job.controller;

import com.jat.ApplicationApi;
import com.jat.model.*;
import com.tracker.application.job.model.JobApplication;
import com.tracker.application.job.service.JobApplicationService;
import com.tracker.application.job.utility.JatUtility;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * This Rest Controller contains all APIs associated with job application.
 *
 * @author Praveen J
 */
@RestController
@AllArgsConstructor
@RequestMapping("/application")
public class JobApplicationController implements ApplicationApi {

    @Autowired
    private JobApplicationService jobApplicationService;

    @Override
    @PostMapping("/add")
    public ResponseEntity<AddApplicationResponse> addApplication(@Valid AddApplicationRequest addApplicationRequest) {
        JobApplication map = JatUtility.map(addApplicationRequest);
        // calling service method to add application
        AddApplicationResponse addApplicationResponse = this.jobApplicationService.addApplication(JatUtility.map(addApplicationRequest));

        // returning 200 OK after successful registration
        return new ResponseEntity<>(addApplicationResponse, HttpStatus.OK);
    }

    @Override
    @GetMapping("/{emailId}")
    public ResponseEntity<GetApplicationsResponse> getApplications(@PathVariable(name = "emailId") String emailId) {
        // calling service to fetch job applications associated with email id
        List<JobApplicationModel> jobApplicationModels = this.jobApplicationService.getApplications(emailId);

        // building response
        GetApplicationsResponse getApplicationsResponse = new GetApplicationsResponse();

        // checking the job applications are available
        if (jobApplicationModels.isEmpty()) {
            getApplicationsResponse.setCount(0);
        } else {
            getApplicationsResponse.setCount(jobApplicationModels.size());
            getApplicationsResponse.setApplications(jobApplicationModels);
        }

        // returning response
        return new ResponseEntity<>(getApplicationsResponse, HttpStatus.OK);
    }

    @Override
    @GetMapping("/details/{jatId}")
    public ResponseEntity<JobApplicationDetailsModel> getApplicationDetails(@PathVariable(name = "jatId") String jatId) {
        // calling service method to fetch application details
        JobApplicationDetailsModel jobApplicationDetailsModel = this.jobApplicationService.getApplicationDetails(jatId);

        // returning application details
        return new ResponseEntity<>(jobApplicationDetailsModel, HttpStatus.OK);
    }
}
