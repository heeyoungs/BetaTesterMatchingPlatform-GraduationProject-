package com.wisoft.io.testermatchingplatform.web.dto.req.questmaker;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class QuestMakerSignupRequest {
    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String password;
    @NotBlank
    @Size(min = 2,max = 10)
    private String nickname;
    @NotBlank
    private String phoneNumber;
}
