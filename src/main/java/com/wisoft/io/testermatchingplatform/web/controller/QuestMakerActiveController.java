package com.wisoft.io.testermatchingplatform.web.controller;

import com.wisoft.io.testermatchingplatform.annotation.Login;
import com.wisoft.io.testermatchingplatform.handler.exception.questmaker.QuestMakerNotLoginException;
import com.wisoft.io.testermatchingplatform.service.QuestMakerActiveService;
import com.wisoft.io.testermatchingplatform.web.dto.req.apply.ApproveRequest;
import com.wisoft.io.testermatchingplatform.web.dto.req.quest.QuestRegistRequest;
import com.wisoft.io.testermatchingplatform.web.dto.resp.apply.ApplyIdResponse;
import com.wisoft.io.testermatchingplatform.web.dto.resp.apply.ApplyTesterDetailResponse;
import com.wisoft.io.testermatchingplatform.web.dto.resp.apply.ApplyTesterListResponse;
import com.wisoft.io.testermatchingplatform.web.dto.resp.quest.QuestIdResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/questMakers")
public class QuestMakerActiveController {

    private final QuestMakerActiveService questMakerActiveService;

    @PostMapping("/quests")
    public ResponseEntity<QuestIdResponse> registQuest(@Login final Long id, @RequestBody final QuestRegistRequest request) {
        loginCheck(id);
        QuestIdResponse response = questMakerActiveService.registQuest(request, id);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/quests")
    public ResponseEntity deleteQuest(@Login final Long id, @RequestParam final Long quest_id) {
        loginCheck(id);
        questMakerActiveService.deleteQuest(quest_id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/quests")
    public ResponseEntity<QuestIdResponse> updateQuest(@Login final Long id, @RequestParam final Long quest_id, @RequestBody final QuestRegistRequest request) {
        loginCheck(id);
        QuestIdResponse response = questMakerActiveService.updateQuest(id, quest_id, request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/quests/{questId}/applies")
    public ResponseEntity<List<ApplyTesterListResponse>> applyTesterList(
            @Login final Long id, @PathVariable final Long questId
    ) {
        loginCheck(id);
        List<ApplyTesterListResponse> responseList = questMakerActiveService.selectQuestApplyTester(questId);
        return ResponseEntity.ok().body(responseList);
    }

    @GetMapping("/quests/applies")
    public ResponseEntity<ApplyTesterDetailResponse> applyTesterDetail(
            @Login final Long id,
            @RequestParam final Long apply_id
    ) {
        loginCheck(id);
        ApplyTesterDetailResponse response = questMakerActiveService.selectApplyTesterDetail(apply_id);
        return ResponseEntity.ok().body(response);
    }

    @PutMapping("/quests/applies")
    public ResponseEntity<ApplyIdResponse> applyTesterApprove(
            @Login final Long id,
            @RequestParam final Long apply_id,
            @RequestBody final ApproveRequest approveRequest
    ) {
        loginCheck(id);
        ApplyIdResponse response = questMakerActiveService.applyTesterApprove(apply_id,approveRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    private void loginCheck(Long id) {
        if (id == null) throw new QuestMakerNotLoginException("");
    }

}
