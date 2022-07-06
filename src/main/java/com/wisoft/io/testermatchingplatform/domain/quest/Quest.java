package com.wisoft.io.testermatchingplatform.domain.quest;

import com.wisoft.io.testermatchingplatform.domain.category.Category;
import com.wisoft.io.testermatchingplatform.domain.questmaker.QuestMaker;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class Quest {
    private Long id;
    private String title;
    private String content;
    private Category category;
    private Date registerTime;
    private Date recruitmentTimeStart;
    private Date recruitmentTimeLimit;
    private Date durationTimeStart;
    private Date durationTimeLimit;
    private Date modifyTimeStart;
    private Date modifyTimeLimit;
    private QuestMaker questMaker;
    private int participantCapacity;
    private int reward;
    private String requireCondition;
    private String preferenceCondition;

    public Quest(String title, String content, Category category, Date registerTime, Date recruitmentTimeStart, Date recruitmentTimeLimit, Date durationTimeStart, Date durationTimeLimit, Date modifyTimeStart, Date modifyTimeLimit, QuestMaker questMaker, int participantCapacity, int reward, String requireCondition, String preferenceCondition) {
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
