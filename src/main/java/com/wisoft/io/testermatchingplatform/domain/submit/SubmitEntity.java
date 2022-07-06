package com.wisoft.io.testermatchingplatform.domain.submit;

import com.wisoft.io.testermatchingplatform.domain.quest.QuestEntity;
import com.wisoft.io.testermatchingplatform.domain.tester.TesterEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "submit")
@Data
@NoArgsConstructor
public class SubmitEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date registerTime;
    private Date reportTime;
    @JoinColumn(name = "TESTER_ID")
    @ManyToOne
    private TesterEntity tester;
    @JoinColumn(name = "QUEST_ID")
    @ManyToOne
    private QuestEntity quest;

    public static SubmitEntity from(final Submit submit){
        return new SubmitEntity(
                submit.getId(),
                submit.getRegisterTime(),
                submit.getReportTime(),
                TesterEntity.from(submit.getTester()),
                QuestEntity.from(submit.getQuest())
        );
    }

    public SubmitEntity(Long id, Date registerTime, Date reportTime, TesterEntity tester, QuestEntity quest) {
        this.id = id;
        this.registerTime = registerTime;
        this.reportTime = reportTime;
        this.tester = tester;
        this.quest = quest;
    }

    public Submit toDomain(){
        return new Submit(
                this.id,
                this.registerTime,
                this.reportTime,
                this.tester.toDomain(),
                this.quest.toDomain()
        );
    }
}
