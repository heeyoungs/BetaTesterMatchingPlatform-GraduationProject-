package com.wisoft.io.testermatchingplatform.domain.tasksubmit;

import com.wisoft.io.testermatchingplatform.domain.submit.SubmitEntity;
import com.wisoft.io.testermatchingplatform.domain.task.TaskEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "task_submit")
@NoArgsConstructor
public class TaskSubmitEntity {

    @EmbeddedId
    private TaskSubmitId id;

    private String file_submit_ref;
    private boolean isPass;

    public static TaskSubmitEntity from(final TaskSubmit taskSubmit){
        return new TaskSubmitEntity(
                new TaskSubmitId(SubmitEntity.from(taskSubmit.getSubmit()), TaskEntity.from(taskSubmit.getTask())),
                taskSubmit.getFile_submit_ref(),
                taskSubmit.isPass()
        );
    }

    public TaskSubmitEntity(TaskSubmitId id, String file_submit_ref, boolean isPass) {
        this.id = id;
        this.file_submit_ref = file_submit_ref;
        this.isPass = isPass;
    }

    public TaskSubmit toDomain(){
        return new TaskSubmit(
                this.id.getSubmit().toDomain(),
                this.id.getTask().toDomain(),
                this.file_submit_ref,
                this.isPass
        );
    }
}
