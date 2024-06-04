package com.tracker.application.job;

import com.jat.model.AddApplicationRequest;
import com.tracker.application.job.model.JobApplication;
import com.tracker.application.job.model.enums.Status;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import java.time.OffsetDateTime;

public class UtilityTest {

    @Test
    public void functionTest() {
        ModelMapper modelMapper = new ModelMapper();

        AddApplicationRequest addApplicationRequest = getAddApplicationRequest();

        JobApplication jobApplication = modelMapper.map(addApplicationRequest, JobApplication.class);

        modelMapper.map(addApplicationRequest, JobApplication.class);



    }

    private static AddApplicationRequest getAddApplicationRequest() {
        AddApplicationRequest addApplicationRequest = new AddApplicationRequest();

//        addApplicationRequest.setCompanyName("McLaren");
        addApplicationRequest.setJobRole("Developer");
        addApplicationRequest.setLocation("BLR");
        addApplicationRequest.setEmailId("blr@yopmail.com");
        addApplicationRequest.setReferral("YES");
        addApplicationRequest.setReferralEmail("ka@yopmail.com");
        addApplicationRequest.setMutualFriend("John");
        addApplicationRequest.setJdLink("http");
        addApplicationRequest.setJd("Hello");
        addApplicationRequest.setDashboardLink("http");
        addApplicationRequest.setStatus(Status.APPLIED.toString());
        addApplicationRequest.setComments("No Comments");

        return addApplicationRequest;
    }

}
