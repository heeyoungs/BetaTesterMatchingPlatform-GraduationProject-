package com.wisoft.io.testermatchingplatform.web.dto.resp.quest;

import com.wisoft.io.testermatchingplatform.domain.quest.Quest;
import com.wisoft.io.testermatchingplatform.domain.task.Task;
import com.wisoft.io.testermatchingplatform.web.dto.resp.task.TaskResponse;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
public class QuestInfoResponse {

    private String title;
    private String content;
    private String categoryName;
    private Date registerTime;
    private Date recruitmentTimeStart;
    private Date recruitmentTimeLimit;
    private Date durationTimeStart;
    private Date durationTimeLimit;
    private Date modifyTimeStart;
    private Date modifyTimeLimit;
    private String questMakerName;
    private int participantCapacity;
    private int reward;
    private String requireCondition;
    private String preferenceCondition;
    private List<TaskResponse> taskList;

    public static QuestInfoResponse from(final Quest quest,final List<TaskResponse> taskList){
        return new QuestInfoResponse(
                quest.getTitle(),
                quest.getContent(),
                quest.getCategory().getName(),
                quest.getRegisterTime(),
                quest.getRecruitmentTimeStart(),
                quest.getRecruitmentTimeLimit(),
                quest.getDurationTimeStart(),
                quest.getDurationTimeLimit(),
                quest.getModifyTimeStart(),
                quest.getModifyTimeLimit(),
                quest.getQuestMaker().getNickname(),
                quest.getParticipantCapacity(),
                quest.getReward(),
                quest.getRequireCondition(),
                quest.getPreferenceCondition(),
                taskList
        );
    }
}
