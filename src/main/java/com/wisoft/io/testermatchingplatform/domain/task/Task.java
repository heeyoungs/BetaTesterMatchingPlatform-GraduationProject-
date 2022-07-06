package com.wisoft.io.testermatchingplatform.domain.task;

import com.wisoft.io.testermatchingplatform.domain.quest.Quest;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Task {

    private Long id;
    private Long taskNumber;
    private Quest quest;
    private String taskExampleRef;
    private String require;
}
