package com.wisoft.io.testermatchingplatform.domain.questmakerreport;

import com.wisoft.io.testermatchingplatform.domain.apply.ApplyEntity;
import com.wisoft.io.testermatchingplatform.domain.reportpolicy.ReportPolicyEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "quest_maker_report")
@NoArgsConstructor
public class QuestMakerReportEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "APPLY_ID")
    private ApplyEntity apply;
    @OneToOne
    @JoinColumn(name = "REPORT_POLICY_ID")
    private ReportPolicyEntity report;
    private String title;
    private Date registerTime;
    private boolean result;

    public static QuestMakerReportEntity from(final QuestMakerReport questMakerReport){
        return new QuestMakerReportEntity(
                questMakerReport.getId(),
                ApplyEntity.from(questMakerReport.getApply()),
                ReportPolicyEntity.from(questMakerReport.getReport()),
                questMakerReport.getTitle(),
                questMakerReport.getRegisterTime(),
                questMakerReport.isResult()
        );
    }

    public QuestMakerReportEntity(Long id, ApplyEntity apply, ReportPolicyEntity report, String title, Date registerTime, boolean result) {
        this.id = id;
        this.apply = apply;
        this.report = report;
        this.title = title;
        this.registerTime = registerTime;
        this.result = result;
    }

    public QuestMakerReport toDomain(){
        return new QuestMakerReport(
                this.id,
                this.apply.toDomain(),
                this.report.toDomain(),
                this.title,
                this.registerTime,
                this.result
        );
    }
}
