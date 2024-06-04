package com.tracker.application.job.utility;

import com.jat.model.AddApplicationRequest;
import com.jat.model.JobApplicationDetailsModel;
import com.jat.model.JobApplicationModel;
import com.jat.model.RegisterUserRequest;
import com.tracker.application.job.model.JobApplication;
import com.tracker.application.job.model.User;
import org.modelmapper.ModelMapper;

public final class JatUtility {

    private static final ModelMapper mapper = new ModelMapper();

    private JatUtility() {
    }

    public static User map(RegisterUserRequest registerUserRequest) {
        return mapper.map(registerUserRequest, User.class);
    }

    public static JobApplication map(AddApplicationRequest addApplicationRequest) {
        return mapper.map(addApplicationRequest, JobApplication.class);
    }

    public static JobApplicationModel map(JobApplication jobApplication) {
        return mapper.map(jobApplication, JobApplicationModel.class);
    }

    public static JobApplicationDetailsModel mapToApplicationDetailsModel(JobApplication jobApplication) {
        return mapper.map(jobApplication, JobApplicationDetailsModel.class);
    }

}
