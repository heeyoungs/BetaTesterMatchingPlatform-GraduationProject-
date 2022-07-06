package com.wisoft.io.testermatchingplatform.domain.submit;

import com.wisoft.io.testermatchingplatform.domain.quest.Quest;
import com.wisoft.io.testermatchingplatform.domain.tester.Tester;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class Submit {

    private Long id;
    private Date registerTime;
    private Date reportTime;
    private Tester tester;
    private Quest quest;
}
