package com.wisoft.io.testermatchingplatform.domain.testerreport;

import com.wisoft.io.testermatchingplatform.domain.reportpolicy.ReportPolicyEntity;
import com.wisoft.io.testermatchingplatform.domain.submit.SubmitEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "tester_report")
@NoArgsConstructor
public class TesterReportEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JoinColumn(name = "SUBMIT_ID")
    @OneToOne
    private SubmitEntity submit;
    @JoinColumn(name = "REPORT_POLICY_ID")
    @OneToOne
    private ReportPolicyEntity report;
    private String title;
    private Date registerTime;
    private boolean result;

    public static TesterReportEntity from(final TesterReport testerReport){
        return new TesterReportEntity(
                testerReport.getId(),
                SubmitEntity.from(testerReport.getSubmit()),
                ReportPolicyEntity.from(testerReport.getReport()),
                testerReport.getTitle(),
                testerReport.getRegisterTime(),
                testerReport.isResult()
        );
    }

    public TesterReportEntity(Long id, SubmitEntity submit, ReportPolicyEntity report, String title, Date registerTime, boolean result) {
        this.id = id;
        this.submit = submit;
        this.report = report;
        this.title = title;
        this.registerTime = registerTime;
        this.result = result;
    }

    public TesterReport toDomain(){
        return new TesterReport(
                this.id,
                this.submit.toDomain(),
                this.report.toDomain(),
                this.title,
                this.registerTime,
                this.result
        );
    }
}
