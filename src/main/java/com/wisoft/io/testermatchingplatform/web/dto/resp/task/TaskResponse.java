package com.wisoft.io.testermatchingplatform.web.dto.resp.task;

import com.wisoft.io.testermatchingplatform.domain.task.Task;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TaskResponse {

    private Long taskNumber;
    private String taskExampleRef;
    private String require;

    public static TaskResponse from(final Task task){
        return new TaskResponse(
                task.getTaskNumber(),
                task.getTaskExampleRef(),
                task.getRequire()
        );
    }
}
