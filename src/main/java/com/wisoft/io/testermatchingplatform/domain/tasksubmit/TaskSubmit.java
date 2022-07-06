package com.wisoft.io.testermatchingplatform.domain.tasksubmit;

import com.wisoft.io.testermatchingplatform.domain.submit.Submit;
import com.wisoft.io.testermatchingplatform.domain.task.Task;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TaskSubmit {

    private Submit submit;
    private Task task;
    private String file_submit_ref;
    private boolean isPass;
}
