package com.wisoft.io.testermatchingplatform.web.dto.req.questmaker;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class QuestMakerSigninRequest {
    @Email
    @NotBlank
    private String email;
    @NotBlank
    private String password;
}
