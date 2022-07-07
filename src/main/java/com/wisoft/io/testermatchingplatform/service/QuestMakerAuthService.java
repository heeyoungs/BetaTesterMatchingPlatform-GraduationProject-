package com.wisoft.io.testermatchingplatform.service;

import com.wisoft.io.testermatchingplatform.domain.questmaker.QuestMaker;
import com.wisoft.io.testermatchingplatform.domain.questmaker.QuestMakerEntity;
import com.wisoft.io.testermatchingplatform.domain.questmaker.QuestMakerRepository;
import com.wisoft.io.testermatchingplatform.handler.exception.questmaker.InvaildPhoneNumberException;
import com.wisoft.io.testermatchingplatform.validator.PhoneNumberValidation;
import com.wisoft.io.testermatchingplatform.web.dto.req.questmaker.QuestMakerSigninRequest;
import com.wisoft.io.testermatchingplatform.web.dto.req.questmaker.QuestMakerSignupRequest;
import com.wisoft.io.testermatchingplatform.web.dto.resp.questmaker.QuestMakerIdResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class QuestMakerAuthService {
    private final QuestMakerRepository questMakerRepository;
    @Transactional
    public QuestMakerIdResponse signupQuestMaker(final QuestMakerSignupRequest request){
        QuestMaker questMaker = new QuestMaker(
                request.getEmail(),
                request.getPassword(),
                request.getNickname(),
                request.getPhoneNumber(),
                new Date()
        );
        // 전화 번호 예외처리
        if(!PhoneNumberValidation.validPhoneNumber(questMaker.getPhoneNumber())){
            throw new InvaildPhoneNumberException("Invalid. Not the form XXX-XXXX-XXX:" + questMaker.getPhoneNumber());
        }

        questMaker = questMakerRepository.save(QuestMakerEntity.from(questMaker)).toDomain();
        return QuestMakerIdResponse.from(questMaker.getId());
    }

    @Transactional
    public void deleteQuestMaker(final Long questMakerId){
        // 회원 탈퇴
        questMakerRepository.deleteById(questMakerId);
    }

    @Transactional
    public QuestMakerIdResponse loginQuestMaker(final QuestMakerSigninRequest request){

        QuestMaker questMaker = questMakerRepository.findByEmail(request.getEmail()).orElseThrow(
                // 예외 처리
        ).toDomain();

        questMaker.checkPassword(request.getPassword());

        return QuestMakerIdResponse.from(questMaker.getId());
    }
}
