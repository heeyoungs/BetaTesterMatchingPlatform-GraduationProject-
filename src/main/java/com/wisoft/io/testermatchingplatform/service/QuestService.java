package com.wisoft.io.testermatchingplatform.service;

import com.wisoft.io.testermatchingplatform.domain.category.Category;
import com.wisoft.io.testermatchingplatform.domain.category.CategoryEntity;
import com.wisoft.io.testermatchingplatform.domain.category.CategoryRepository;
import com.wisoft.io.testermatchingplatform.domain.quest.Quest;
import com.wisoft.io.testermatchingplatform.domain.quest.QuestEntity;
import com.wisoft.io.testermatchingplatform.domain.quest.QuestRepository;
import com.wisoft.io.testermatchingplatform.domain.questmaker.QuestMaker;
import com.wisoft.io.testermatchingplatform.domain.questmaker.QuestMakerEntity;
import com.wisoft.io.testermatchingplatform.domain.questmaker.QuestMakerRepository;
import com.wisoft.io.testermatchingplatform.web.dto.req.quest.QuestRegistRequest;
import com.wisoft.io.testermatchingplatform.web.dto.resp.quest.QuestIdResponse;
import com.wisoft.io.testermatchingplatform.web.dto.resp.quest.QuestInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// badRequest 처리
@Service
@RequiredArgsConstructor // final , not null -> 자동 주입 (생성자 주입)
public class QuestService {
    private final QuestRepository questRepository;
    private final CategoryRepository categoryRepository;
    private final QuestMakerRepository questMakerRepository;

    @Transactional
    // 전체 조회
    public List<QuestInfoResponse> all() {
        List<QuestEntity> questList = questRepository.findAll();
        List<QuestInfoResponse> responseList = new ArrayList<>();
        for (QuestEntity q: questList){
            responseList.add(QuestInfoResponse.from(q.toDomain()));
        }
        return responseList;
    }

    @Transactional
    // 카테고리 조회 조회
    public List<QuestInfoResponse> findByCategoryId(final Long category_id) {
        List<QuestEntity> questSelectServiceByCategory_id = this.questRepository.findByCategory_Id(category_id);
        List<QuestInfoResponse> responseList = new ArrayList<>();
        for (QuestEntity q: questSelectServiceByCategory_id){
            responseList.add(QuestInfoResponse.from(q.toDomain()));
        }
        return responseList;
    }

    @Transactional
    // Qm으로 조회
    public List<QuestInfoResponse> findByNtcId(final Long ntc_id) {
         List<QuestEntity> questSelectServiceByCategory_id = this.questRepository.findByQuestMaker_Id(ntc_id);
        List<QuestInfoResponse> responseList = new ArrayList<>();
        for (QuestEntity q: questSelectServiceByCategory_id){
            responseList.add(QuestInfoResponse.from(q.toDomain()));
        }
        return responseList;
    }

    // 하나만 조회
    @Transactional
    public QuestInfoResponse findById(final Long id){
        Quest quest = questRepository.findById(id).orElseThrow().toDomain();
        return QuestInfoResponse.from(quest);
    }

    // 퀘스트 등록
    @Transactional
    public QuestIdResponse registQuest(final QuestRegistRequest request, final Long questmakerId){
        Category category = categoryRepository.findByName(request.getCategoryName()).orElseThrow().toDomain();
        QuestMaker questMaker = questMakerRepository.findById(questmakerId).orElseThrow().toDomain();

        Quest quest = new Quest(
                request.getTitle(),
                request.getContent(),
                category,
                new Date(),
                request.getRecruitmentTimeStart(),
                request.getRecruitmentTimeLimit(),
                request.getDurationTimeStart(),
                request.getDurationTimeLimit(),
                request.getModifyTimeStart(),
                request.getModifyTimeLimit(),
                questMaker,
                request.getParticipantCapacity(),
                request.getReward(),
                request.getRequireCondition(),
                request.getPreferenceCondition()
        );

        quest = questRepository.save(QuestEntity.from(quest)).toDomain();
        return QuestIdResponse.from(quest.getId());
    }

    // 퀘스트 삭제
    @Transactional
    public void deleteQuest(final Long questmakerId, final Long questId){
        // questmakerId가 로그인 정보와 동일한지 확인 후
        questRepository.deleteById(questId);
    }

    // 퀘스트 수정
    @Transactional
    public QuestIdResponse updateQuest(final Long questmakerId,final Long questId,final QuestRegistRequest request){
        Category category = categoryRepository.findByName(request.getCategoryName()).orElseThrow().toDomain();
        QuestMaker questMaker = questMakerRepository.findById(questmakerId).orElseThrow().toDomain();

        Quest quest = new Quest(
                questId,
                request.getTitle(),
                request.getContent(),
                category,
                new Date(),
                request.getRecruitmentTimeStart(),
                request.getRecruitmentTimeLimit(),
                request.getDurationTimeStart(),
                request.getDurationTimeLimit(),
                request.getModifyTimeStart(),
                request.getModifyTimeLimit(),
                questMaker,
                request.getParticipantCapacity(),
                request.getReward(),
                request.getRequireCondition(),
                request.getPreferenceCondition()
        );

        quest = questRepository.save(QuestEntity.from(quest)).toDomain();
        return QuestIdResponse.from(quest.getId());

    }
}