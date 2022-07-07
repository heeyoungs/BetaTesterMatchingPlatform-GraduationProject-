package com.wisoft.io.testermatchingplatform.domain.tester;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.wisoft.io.testermatchingplatform.domain.apply.ApplyEntity;
import com.wisoft.io.testermatchingplatform.domain.category.CategoryEntity;
import com.wisoft.io.testermatchingplatform.domain.grade.GradeEntity;
import com.wisoft.io.testermatchingplatform.domain.submit.SubmitEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "tester")
@NoArgsConstructor
public class TesterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String password;

    private String nickname;

    private String phoneNumber;

    @JoinColumn(name = "PREFER_CATEGORY_ID")
    @ManyToOne
    private CategoryEntity preferCategory;

    private String introMessage;

    private String introPictureRef;

    @JoinColumn(name = "GRADE_ID")
    @ManyToOne
    private GradeEntity grade;

    private Date registerTime;

    @OneToMany(mappedBy = "tester",cascade = CascadeType.ALL,orphanRemoval = true)
    @JsonBackReference
    private List<ApplyEntity> applyEntities = new ArrayList<>();

    @OneToMany(mappedBy = "tester",cascade = CascadeType.ALL,orphanRemoval = true)
    @JsonBackReference
    private List<SubmitEntity> submitEntities = new ArrayList<>();

    public TesterEntity(Long id, String email, String password, String nickname, String phoneNumber, CategoryEntity preferCategory, String introMessage, String introPictureRef, GradeEntity grade, Date registerTime) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.phoneNumber = phoneNumber;
        this.preferCategory = preferCategory;
        this.introMessage = introMessage;
        this.introPictureRef = introPictureRef;
        this.grade = grade;
        this.registerTime = registerTime;
    }


    public static TesterEntity from(final Tester tester) {
        return new TesterEntity(
                tester.getId(),
                tester.getEmail(),
                tester.getPassword(),
                tester.getNickname(),
                tester.getPhoneNumber(),
                CategoryEntity.from(tester.getPreferCategory()),
                tester.getIntroMessage(),
                tester.getIntroPictureRef(),
                GradeEntity.from(tester.getGrade()),
                tester.getRegisterTime()
        );
    }

    public Tester toDomain() {
        return new Tester(
                this.id,
                this.email,
                this.password,
                this.nickname,
                this.phoneNumber,
                this.preferCategory.toDomain(),
                this.introMessage,
                this.introPictureRef,
                this.grade.toDomain(),
                this.registerTime
        );
    }
}
