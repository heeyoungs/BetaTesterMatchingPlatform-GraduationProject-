package com.wisoft.io.testermatchingplatform.domain.auth;

import com.wisoft.io.testermatchingplatform.domain.submit.SubmitEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "auth")
@NoArgsConstructor
public class AuthEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "SUBMIT_ID")
    private SubmitEntity submit;
    private Long status;
    private String comment;

    public AuthEntity(Long id, SubmitEntity submit, Long status, String comment) {
        this.id = id;
        this.submit = submit;
        this.status = status;
        this.comment = comment;
    }

    public static AuthEntity from(final Auth auth){
        return new AuthEntity(
                auth.getId(),
                SubmitEntity.from(auth.getSubmit()),
                auth.getStatus(),
                auth.getComment()
        );
    }

    public Auth toDomain(){
        return new Auth(
                this.id,
                this.submit.toDomain(),
                this.status,
                this.comment
        );
    }
}
