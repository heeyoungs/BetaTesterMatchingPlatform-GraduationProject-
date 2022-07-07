package com.wisoft.io.testermatchingplatform.domain.apply;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.wisoft.io.testermatchingplatform.domain.quest.QuestEntity;
import com.wisoft.io.testermatchingplatform.domain.tester.TesterEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "apply")
@NoArgsConstructor
public class ApplyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date registerTime;
    private Date permissionTime;
    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "TESTER_ID")
    private TesterEntity tester;
    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "QUEST_ID")
    private QuestEntity quest;
    private String requireConditionSubmitRef;
    private String preferenceConditionSubmitRef;

    public ApplyEntity(Long id, Date registerTime, Date permissionTime, TesterEntity tester, QuestEntity quest, String requireConditionSubmitRef, String preferenceConditionSubmitRef) {
        this.id = id;
        this.registerTime = registerTime;
        this.permissionTime = permissionTime;
        this.tester = tester;
        this.quest = quest;
        this.requireConditionSubmitRef = requireConditionSubmitRef;
        this.preferenceConditionSubmitRef = preferenceConditionSubmitRef;
    }

    public static ApplyEntity from(final Apply apply){
        return new ApplyEntity(
                apply.getId(),
                apply.getRegisterTime(),
                apply.getPermissionTime(),
                TesterEntity.from(apply.getTester()),
                QuestEntity.from(apply.getQuest()),
                apply.getRequireConditionSubmitRef(),
                apply.getPreferenceConditionSubmitRef()
        );
    }

    public Apply toDomain(){
        return new Apply(
                this.id,
                this.registerTime,
                this.permissionTime,
                this.tester.toDomain(),
                this.quest.toDomain(),
                this.requireConditionSubmitRef,
                this.preferenceConditionSubmitRef
        );
    }
}
