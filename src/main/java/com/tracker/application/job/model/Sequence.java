package com.tracker.application.job.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document(collection = "Sequence")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sequence {

    @Id
    private String sequenceName;

    private Long count;

}
