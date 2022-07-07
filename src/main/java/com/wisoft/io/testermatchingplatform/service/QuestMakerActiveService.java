package com.wisoft.io.testermatchingplatform.service;

import com.wisoft.io.testermatchingplatform.domain.apply.Apply;
import com.wisoft.io.testermatchingplatform.domain.apply.ApplyEntity;
import com.wisoft.io.testermatchingplatform.domain.apply.ApplyRepository;
import com.wisoft.io.testermatchingplatform.domain.category.Category;
import com.wisoft.io.testermatchingplatform.domain.category.CategoryRepository;
import com.wisoft.io.testermatchingplatform.domain.quest.Quest;
import com.wisoft.io.testermatchingplatform.domain.quest.QuestEntity;
import com.wisoft.io.testermatchingplatform.domain.quest.QuestRepository;
import com.wisoft.io.testermatchingplatform.domain.questmaker.QuestMaker;
import com.wisoft.io.testermatchingplatform.domain.questmaker.QuestMakerRepository;
import com.wisoft.io.testermatchingplatform.domain.submit.SubmitEntity;
import com.wisoft.io.testermatchingplatform.domain.submit.SubmitRepository;
import com.wisoft.io.testermatchingplatform.web.dto.req.apply.ApproveRequest;
import com.wisoft.io.testermatchingplatform.web.dto.req.quest.QuestRegistRequest;
import com.wisoft.io.testermatchingplatform.web.dto.resp.apply.ApplyIdResponse;
import com.wisoft.io.testermatchingplatform.web.dto.resp.apply.ApplyTesterDetailResponse;
import com.wisoft.io.testermatchingplatform.web.dto.resp.apply.ApplyTesterListResponse;
import com.wisoft.io.testermatchingplatform.web.dto.resp.quest.QuestIdResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QuestMakerActiveService {

    private final QuestMakerRepository questMakerRepository;
    private final CategoryRepository categoryRepository;
    private final QuestRepository questRepository;

    private final ApplyRepository applyRepository;

    // 퀘스트 등록
    @Transactional
    public QuestIdResponse registQuest(final QuestRegistRequest request, final Long questMakerId) {
        Category category = categoryRepository.findByName(request.getCategoryName()).orElseThrow(
                // 예외 처리
        ).toDomain();
        QuestMaker questMaker = questMakerRepository.findById(questMakerId).orElseThrow(
                // 예최 처리
        ).toDomain();

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
        return QuestIdResponse.from(quest);
    }

    // 퀘스트 삭제
    @Transactional
    public void deleteQuest(final Long questId) {
        questRepository.deleteById(questId);

    }

    // 퀘스트 수정
    @Transactional
    public QuestIdResponse updateQuest(final Long questMakerId, final Long questId, final QuestRegistRequest request) {
        Category category = categoryRepository.findByName(request.getCategoryName()).orElseThrow(
                // 예외 처리
        ).toDomain();
        QuestMaker questMaker = questMakerRepository.findById(questMakerId).orElseThrow(
                // 예외 처리
        ).toDomain();

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
        return QuestIdResponse.from(quest);

    }

    // 퀘스트 신청자 조회
    @Transactional
    public List<ApplyTesterListResponse> selectQuestApplyTester(final Long questId) {
        return applyRepository.findByQuest_Id(questId).
                stream()
                .map(ApplyEntity->ApplyTesterListResponse.from(ApplyEntity.toDomain()))
                .collect(Collectors.toList());
    }

    // 퀘스트 신청자 세부 조회
    @Transactional
    public ApplyTesterDetailResponse selectApplyTesterDetail(final Long applyId){
        Apply apply = applyRepository.findById(applyId).orElseThrow(
            // 예외 처리
        ).toDomain();
        return ApplyTesterDetailResponse.from(apply);
    }

    // 퀘스트 신청자 승인
    @Transactional
    public ApplyIdResponse applyTesterApprove(final Long applyId, final ApproveRequest approveRequest){
        Apply apply = applyRepository.findById(applyId).orElseThrow(

        ).toDomain();
        apply.setPermissionTime(new Date());

        if (approveRequest.getSuccess() == 1){
            apply = applyRepository.save(ApplyEntity.from(apply)).toDomain();
        }
        return ApplyIdResponse.from(apply);
    }

}
