package com.wisoft.io.testermatchingplatform.web.controller;

import com.wisoft.io.testermatchingplatform.service.QuestService;
import com.wisoft.io.testermatchingplatform.web.dto.resp.quest.QuestInfoResponse;
import com.wisoft.io.testermatchingplatform.web.dto.resp.quest.QuestSimpleInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/quests")
public class QuestController {

    private final QuestService questService;

    @GetMapping("")
    public ResponseEntity<List<QuestSimpleInfoResponse>> questAll(){
        List<QuestSimpleInfoResponse> responseList = questService.all();
        return ResponseEntity.ok().body(responseList);
    }

    @GetMapping("/category")
    public ResponseEntity<List<QuestSimpleInfoResponse>> questFindByCategoryId(@RequestParam final Long category_id){
        List<QuestSimpleInfoResponse> responseList = questService.findByCategoryId(category_id);
        return ResponseEntity.ok().body(responseList);
    }

    @GetMapping("/quest")
    public ResponseEntity<QuestInfoResponse> questFindById(@RequestParam final Long quest_id){
        QuestInfoResponse response = questService.findById(quest_id);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/questMaker")
    public ResponseEntity<List<QuestSimpleInfoResponse>> questFindByQuestMakerId(@RequestParam final Long questMaker_id){
        List<QuestSimpleInfoResponse> response = questService.findByQuestMakerId(questMaker_id);
        return ResponseEntity.ok().body(response);
    }
}
