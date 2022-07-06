package com.wisoft.io.testermatchingplatform.domain.questmaker;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class QuestMaker {
    private Long id;
    private String email;
    private String password;
    private String nickname;
    private String phoneNumber;
    private Date registerTime;

    public QuestMaker(String email, String password, String nickname, String phoneNumber,Date registerTime) {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.phoneNumber = phoneNumber;
        this.registerTime = registerTime;
    }

    public static QuestMaker to(final QuestMakerEntity questMaker){
        return new QuestMaker(
                questMaker.getId(),
                questMaker.getEmail(),
                questMaker.getPassword(),
                questMaker.getNickname(),
                questMaker.getPhoneNumber(),
                questMaker.getRegisterTime()
        );
    }

    public void checkPassword(final String confirmPassword) {
        if (!this.password.equals(confirmPassword)) {
            throw new IllegalArgumentException("패스워드가 일치하지 않습니다.");
        }
    }
}
