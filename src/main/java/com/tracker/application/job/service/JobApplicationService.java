package com.tracker.application.job.service;

import com.jat.model.*;
import com.tracker.application.job.model.JobApplication;

import java.util.List;

public interface JobApplicationService {
    AddApplicationResponse addApplication(JobApplication jobApplication);

    List<JobApplicationModel> getApplications(String emailId);

    JobApplicationDetailsModel getApplicationDetails(String jatId);
}
