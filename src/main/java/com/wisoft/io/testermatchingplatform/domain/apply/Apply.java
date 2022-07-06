package com.wisoft.io.testermatchingplatform.domain.apply;

import com.wisoft.io.testermatchingplatform.domain.quest.Quest;
import com.wisoft.io.testermatchingplatform.domain.tester.Tester;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class Apply {
    private Long id;
    private Date registerTime;
    private Date permissionTime;
    private Tester tester;
    private Quest quest;
    private String requireConditionSubmitRef;
    private String preferenceConditionSubmitRef;
}
