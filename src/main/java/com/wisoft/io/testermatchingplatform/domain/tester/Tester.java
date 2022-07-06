package com.wisoft.io.testermatchingplatform.domain.tester;

import com.wisoft.io.testermatchingplatform.domain.category.Category;
import com.wisoft.io.testermatchingplatform.domain.category.CategoryEntity;
import com.wisoft.io.testermatchingplatform.domain.grade.Grade;
import com.wisoft.io.testermatchingplatform.domain.grade.GradeEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

@Getter
@AllArgsConstructor
public class Tester {
    private Long id;
    private String email;
    private String password;
    private String nickname;
    private String phoneNumber;
    private Category preferCategory;
    private String introMessage;
    private String introPictureRef;
    private Grade grade;
    private Date registerTime;
}
