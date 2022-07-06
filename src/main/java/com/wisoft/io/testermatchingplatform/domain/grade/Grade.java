package com.wisoft.io.testermatchingplatform.domain.grade;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Grade {
    private int id;
    private String name;
    private int available_quest_amount;
}
