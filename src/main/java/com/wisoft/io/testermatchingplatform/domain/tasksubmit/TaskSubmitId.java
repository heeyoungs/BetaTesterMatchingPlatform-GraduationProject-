package com.wisoft.io.testermatchingplatform.domain.tasksubmit;

import com.wisoft.io.testermatchingplatform.domain.submit.SubmitEntity;
import com.wisoft.io.testermatchingplatform.domain.task.TaskEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Embeddable
public class TaskSubmitId implements Serializable {

    @JoinColumn(name = "SUBMIT_ID")
    @OneToOne
    private SubmitEntity submit;

    @JoinColumn(name = "TASK_ID")
    @OneToOne
    private TaskEntity task;

    public TaskSubmitId(SubmitEntity submit, TaskEntity task) {
        this.submit = submit;
        this.task = task;
    }
}
