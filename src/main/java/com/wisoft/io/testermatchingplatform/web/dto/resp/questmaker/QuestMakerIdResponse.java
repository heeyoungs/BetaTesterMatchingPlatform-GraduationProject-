package com.wisoft.io.testermatchingplatform.web.dto.resp.questmaker;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class QuestMakerIdResponse {

    private Long id;

    public static QuestMakerIdResponse from(final Long id){
        return new QuestMakerIdResponse(id);
    }
}
