package com.wisoft.io.testermatchingplatform.domain.testerreport;


import com.wisoft.io.testermatchingplatform.domain.reportpolicy.ReportPolicy;
import com.wisoft.io.testermatchingplatform.domain.submit.Submit;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class TesterReport {

    private Long id;
    private Submit submit;
    private ReportPolicy report;
    private String title;
    private Date registerTime;
    private boolean result;
}
