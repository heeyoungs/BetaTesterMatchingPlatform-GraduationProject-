package com.wisoft.io.testermatchingplatform.web.dto.req.quest;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;

import java.sql.Date;

@Getter
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class QuestUpdateRequest {

    private String title;
    private String content;
    private String categoryName;
    private Date registerTime;
    private Date recruitmentTimeStart;
    private Date recruitmentTimeLimit;
    private Date durationTimeStart;
    private Date durationTimeLimit;
    private Date modifyTimeStart;
    private Date modifyTimeLimit;
    private int participantCapacity;
    private int reward;
    private String requireCondition;
    private String preferenceCondition;
}
