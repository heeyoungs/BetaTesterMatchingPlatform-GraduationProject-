package com.wisoft.io.testermatchingplatform.web.controller;

import com.wisoft.io.testermatchingplatform.domain.tester.TesterRepository;
import com.wisoft.io.testermatchingplatform.service.QuestMakerAuthService;
import com.wisoft.io.testermatchingplatform.web.dto.req.questmaker.QuestMakerSigninRequest;
import com.wisoft.io.testermatchingplatform.web.dto.req.questmaker.QuestMakerSignupRequest;
import com.wisoft.io.testermatchingplatform.web.dto.resp.questmaker.QuestMakerIdResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequiredArgsConstructor
@RequestMapping("/accounts/questMakers")
public class QuestMakerAuthController {

    private final QuestMakerAuthService questMakerAuthService;

    // 회원 가입
    @PostMapping("/signup")
    public ResponseEntity<QuestMakerIdResponse> signupQuestMaker(@RequestBody QuestMakerSignupRequest request){
        // 사용자 등록
        QuestMakerIdResponse response = this.questMakerAuthService.signupQuestMaker(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // 회원 탈퇴
    @DeleteMapping("/remove")
    public ResponseEntity deleteQuestMaker(HttpServletRequest httpServletRequest){
        // 사용자 삭제
        HttpSession session = httpServletRequest.getSession(false);
        Long id = (Long) session.getAttribute("questMaker");
        this.questMakerAuthService.deleteQuestMaker(id);
        // 세션 삭제
        session.invalidate();
        return ResponseEntity.noContent().build();
    }

    // 로그인
    @PostMapping("/login")
    public ResponseEntity<QuestMakerIdResponse> loginQuestMaker(
            @RequestBody QuestMakerSigninRequest request,
            HttpServletRequest httpServletRequest
    ){
        QuestMakerIdResponse response = this.questMakerAuthService.loginQuestMaker(request);
        // 세션 등록
        HttpSession session = httpServletRequest.getSession();
        session.setAttribute("questMaker",response.getId());
        session.setMaxInactiveInterval(1800);
        return ResponseEntity.ok().body(response);
    }

    // 로그아웃
    @PostMapping("/logout")
    public ResponseEntity logoutQuestMaker(
            HttpServletRequest httpServletRequest
            ){
        // 세션 삭제
        HttpSession session = httpServletRequest.getSession(false);
        session.invalidate();
        return ResponseEntity.ok().build();
    }

}
