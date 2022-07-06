package com.wisoft.io.testermatchingplatform.web.controller;

import com.wisoft.io.testermatchingplatform.service.QuestMakerService;
import com.wisoft.io.testermatchingplatform.service.QuestService;
import com.wisoft.io.testermatchingplatform.web.dto.req.quest.QuestRegistRequest;
import com.wisoft.io.testermatchingplatform.web.dto.req.questmaker.QuestMakerSigninRequest;
import com.wisoft.io.testermatchingplatform.web.dto.req.questmaker.QuestMakerSignupRequest;
import com.wisoft.io.testermatchingplatform.web.dto.resp.quest.QuestIdResponse;
import com.wisoft.io.testermatchingplatform.web.dto.resp.questmaker.QuestMakerIdResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/questmakers")
public class QuestMakerController {

    private final QuestService questService;
    private final QuestMakerService questMakerService;

    @PostMapping("/{questMakerId}/quests")
    public ResponseEntity<QuestIdResponse> registQuest(@PathVariable final Long questMakerId, @RequestBody final QuestRegistRequest request){
        QuestIdResponse response = this.questService.registQuest(request, questMakerId);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/{questMakerId}/quests/{questId}")
    public ResponseEntity<?> deleteQuest(@PathVariable final Long questMakerId, @PathVariable final Long questId){
        this.questService.deleteQuest(questMakerId,questId);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{questMakerId}/quests/{questId}")
    public ResponseEntity<QuestIdResponse> updateQuest(@PathVariable final Long questMakerId, @PathVariable final Long questId, @RequestBody final QuestRegistRequest request){
        QuestIdResponse response = this.questService.updateQuest(questMakerId,questId,request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/signup")
    public ResponseEntity<QuestMakerIdResponse> signupQuestMaker(@RequestBody QuestMakerSignupRequest request){
        QuestMakerIdResponse response = this.questMakerService.signupQuestMaker(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/{questMakerId}")
    public ResponseEntity<?> deleteQuestMaker(@PathVariable final Long questMakerId){
        this.questMakerService.deleteQuestMaker(questMakerId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/signin")
    public ResponseEntity<QuestMakerIdResponse> signinQuestMaker(@RequestBody QuestMakerSigninRequest request){
        QuestMakerIdResponse response = this.questMakerService.signinQuestMaker(request);
        return ResponseEntity.ok().body(response);
    }

}
