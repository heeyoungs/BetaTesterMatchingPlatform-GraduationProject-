package com.wisoft.io.testermatchingplatform.web.dto.resp.quest;

import com.wisoft.io.testermatchingplatform.domain.quest.Quest;
import com.wisoft.io.testermatchingplatform.domain.task.Task;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;
import java.util.List;

@Getter
@AllArgsConstructor
public class QuestSimpleInfoResponse {

    private String title;
    private String content;
    private String categoryName;
    private Date registerTime;
    private Date recruitmentTimeStart;
    private Date recruitmentTimeLimit;
    private String questMakerName;
    private int participantCapacity;
    private int reward;

    public static QuestSimpleInfoResponse from(final Quest quest){
        return new QuestSimpleInfoResponse(
                quest.getTitle(),
                quest.getContent(),
                quest.getCategory().getName(),
                quest.getRegisterTime(),
                quest.getRecruitmentTimeStart(),
                quest.getRecruitmentTimeLimit(),
                quest.getQuestMaker().getNickname(),
                quest.getParticipantCapacity(),
                quest.getReward()
        );
    }
}
