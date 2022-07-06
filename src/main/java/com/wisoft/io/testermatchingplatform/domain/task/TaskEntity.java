package com.wisoft.io.testermatchingplatform.domain.task;

import com.wisoft.io.testermatchingplatform.domain.quest.QuestEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "task")
@NoArgsConstructor
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long taskNumber;
    @ManyToOne
    @JoinColumn(name = "QUEST_ID")
    private QuestEntity quest;
    private String taskExampleRef;
    private String require;

    public static TaskEntity from(final Task task){
        return new TaskEntity(
                task.getId(),
                task.getTaskNumber(),
                QuestEntity.from(task.getQuest()),
                task.getTaskExampleRef(),
                task.getRequire()
        );
    }

    public TaskEntity(Long id, Long taskNumber, QuestEntity quest, String taskExampleRef, String require) {
        this.id = id;
        this.taskNumber = taskNumber;
        this.quest = quest;
        this.taskExampleRef = taskExampleRef;
        this.require = require;
    }

    public Task toDomain(){
        return new Task(
                this.id,
                this.taskNumber,
                this.quest.toDomain(),
                this.taskExampleRef,
                this.require
        );
    }
}
