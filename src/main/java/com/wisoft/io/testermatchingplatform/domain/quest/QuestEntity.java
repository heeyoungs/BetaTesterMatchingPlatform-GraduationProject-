package com.wisoft.io.testermatchingplatform.domain.quest;

import com.wisoft.io.testermatchingplatform.domain.apply.ApplyEntity;
import com.wisoft.io.testermatchingplatform.domain.category.Category;
import com.wisoft.io.testermatchingplatform.domain.category.CategoryEntity;
import com.wisoft.io.testermatchingplatform.domain.questmaker.QuestMaker;
import com.wisoft.io.testermatchingplatform.domain.questmaker.QuestMakerEntity;
import com.wisoft.io.testermatchingplatform.domain.submit.SubmitEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "quest")
@NoArgsConstructor
public class QuestEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID")
    private CategoryEntity category;
    private Date registerTime;
    private Date recruitmentTimeStart;
    private Date recruitmentTimeLimit;
    private Date durationTimeStart;
    private Date durationTimeLimit;
    private Date modifyTimeStart;
    private Date modifyTimeLimit;
    @ManyToOne
    @JoinColumn(name = "QUEST_MAKER_ID")
    private QuestMakerEntity questMaker;
    private int participantCapacity;
    private int reward;
    private String requireCondition;
    private String preferenceCondition;

    @OneToMany(mappedBy = "quest",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<ApplyEntity> applyEntities = new ArrayList<>();

    @OneToMany(mappedBy = "quest",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<SubmitEntity> submitEntities = new ArrayList<>();
    public Quest toDomain() {
        return new Quest(
                this.id,
                this.title,
                this.content,
                this.category.toDomain(),
                this.registerTime,
                this.recruitmentTimeStart,
                this.recruitmentTimeLimit,
                this.durationTimeStart,
                this.durationTimeLimit,
                this.modifyTimeStart,
                this.modifyTimeLimit,
                this.questMaker.toDomain(),
                this.participantCapacity,
                this.reward,
                this.requireCondition,
                this.preferenceCondition
        );
    }

    public static QuestEntity from(final Quest quest){
        return new QuestEntity(
                quest.getId(),
                quest.getTitle(),
                quest.getContent(),
                CategoryEntity.from(quest.getCategory()),
                quest.getRegisterTime(),
                quest.getRecruitmentTimeStart(),
                quest.getRecruitmentTimeLimit(),
                quest.getDurationTimeStart(),
                quest.getDurationTimeLimit(),
                quest.getModifyTimeStart(),
                quest.getModifyTimeLimit(),
                QuestMakerEntity.from(quest.getQuestMaker()),
                quest.getParticipantCapacity(),
                quest.getReward(),
                quest.getRequireCondition(),
                quest.getPreferenceCondition()
        );
    }

    public QuestEntity(Long id, String title, String content, CategoryEntity category, Date registerTime, Date recruitmentTimeStart, Date recruitmentTimeLimit, Date durationTimeStart, Date durationTimeLimit, Date modifyTimeStart, Date modifyTimeLimit, QuestMakerEntity questMaker, int participantCapacity, int reward, String requireCondition, String preferenceCondition) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.category = category;
        this.registerTime = registerTime;
        this.recruitmentTimeStart = recruitmentTimeStart;
        this.recruitmentTimeLimit = recruitmentTimeLimit;
        this.durationTimeStart = durationTimeStart;
        this.durationTimeLimit = durationTimeLimit;
        this.modifyTimeStart = modifyTimeStart;
        this.modifyTimeLimit = modifyTimeLimit;
        this.questMaker = questMaker;
        this.participantCapacity = participantCapacity;
        this.reward = reward;
        this.requireCondition = requireCondition;
        this.preferenceCondition = preferenceCondition;
    }
}
