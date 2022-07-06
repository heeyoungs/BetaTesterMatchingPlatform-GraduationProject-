package com.wisoft.io.testermatchingplatform.domain.questmakerreport;

import com.wisoft.io.testermatchingplatform.domain.apply.Apply;
import com.wisoft.io.testermatchingplatform.domain.reportpolicy.ReportPolicy;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class QuestMakerReport {

    private Long id;
    private Apply apply;
    private ReportPolicy report;
    private String title;
    private Date registerTime;
    private boolean result;
}
