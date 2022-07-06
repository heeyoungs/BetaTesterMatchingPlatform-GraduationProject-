package com.wisoft.io.testermatchingplatform.domain.evaluation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Table(name = "evalutation")
@Entity
@NoArgsConstructor
public class EvaluationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long authId;
    private Long starPoint;
    private String comment;

    public static EvaluationEntity from(final Evaluation evaluation){
        return new EvaluationEntity(
                evaluation.getAuthId(),
                evaluation.getStarPoint(),
                evaluation.getComment()
        );
    }

    public EvaluationEntity(Long authId, Long starPoint, String comment) {
        this.authId = authId;
        this.starPoint = starPoint;
        this.comment = comment;
    }

    public Evaluation toDomain(){
        return new Evaluation(
                this.authId,
                this.starPoint,
                this.comment
        );
    }
}
