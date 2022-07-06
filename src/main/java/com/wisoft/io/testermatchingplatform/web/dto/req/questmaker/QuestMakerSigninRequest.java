package com.wisoft.io.testermatchingplatform.web.dto.req.questmaker;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;

import javax.validation.constraints.Email;

@Getter
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class QuestMakerSigninRequest {
    private String email;
    private String password;
}
