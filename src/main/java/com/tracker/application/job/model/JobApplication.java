package com.tracker.application.job.model;

import com.tracker.application.job.model.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.OffsetDateTime;

@Document(collection = "Applications")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobApplication {

    @Id
    private String jatId;

    private String companyName;

    private String jobRole;

    private String location;

    private String emailId;

    private String referral;

    private String referralEmail;

    private String mutualFriend;

    private String jdLink;

    private String jd;

    private String dashboardLink;

    private Status status;

    private OffsetDateTime creationDate;

    private OffsetDateTime lastChecked;

    private OffsetDateTime lastEdited;

    private String comments;

}
