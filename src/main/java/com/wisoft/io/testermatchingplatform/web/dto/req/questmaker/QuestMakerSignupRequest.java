package com.wisoft.io.testermatchingplatform.web.dto.req.questmaker;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.ToString;

@Getter
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class QuestMakerSignupRequest {
    private String email;
    private String password;
    private String nickname;
    private String phoneNumber;
}
