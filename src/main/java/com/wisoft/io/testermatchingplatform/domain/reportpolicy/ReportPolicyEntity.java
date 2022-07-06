package com.wisoft.io.testermatchingplatform.domain.reportpolicy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "report_policy")
@NoArgsConstructor
public class ReportPolicyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String category;
    private String content;
    private Long penalty;

    public static ReportPolicyEntity from(final ReportPolicy reportPolicy){
        return new ReportPolicyEntity(
                reportPolicy.getId(),
                reportPolicy.getCategory(),
                reportPolicy.getContent(),
                reportPolicy.getPenalty()
        );
    }

    public ReportPolicyEntity(Long id, String category, String content, Long penalty) {
        this.id = id;
        this.category = category;
        this.content = content;
        this.penalty = penalty;
    }

    public ReportPolicy toDomain(){
        return new ReportPolicy(
                this.id,
                this.category,
                this.content,
                this.penalty
        );
    }
}
