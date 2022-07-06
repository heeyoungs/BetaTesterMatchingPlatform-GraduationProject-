package com.wisoft.io.testermatchingplatform.domain.auth;

import com.wisoft.io.testermatchingplatform.domain.submit.Submit;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Auth {
    private Long id;
    private Submit submit;
    private Long status;
    private String comment;
}
