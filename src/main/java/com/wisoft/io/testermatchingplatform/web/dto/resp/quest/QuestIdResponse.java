package com.wisoft.io.testermatchingplatform.web.dto.resp.quest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class QuestIdResponse {

    private Long id;

    public static QuestIdResponse from(final Long id) {
        return new QuestIdResponse(id);
    }
}
