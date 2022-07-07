package com.wisoft.io.testermatchingplatform.web.dto.resp.quest;

import com.wisoft.io.testermatchingplatform.domain.quest.Quest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class QuestIdResponse {

    private Long id;

    public static QuestIdResponse from(final Quest quest) {
        return new QuestIdResponse(quest.getId());
    }
}
