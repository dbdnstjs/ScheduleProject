package com.schedule.Lv6.controller;

import com.schedule.Lv6.dto.AuthRequest;
import com.schedule.Lv6.dto.AuthResponse;
import com.schedule.Lv6.service.AuthService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/signup")
    public String signup(@RequestBody @Valid AuthRequest authRequest) {
        authService.signup(authRequest);
        return "회원가입 성공";
    }

    @PostMapping("/login")
    public String login(@RequestBody @Valid AuthRequest authRequest, HttpServletRequest request) {
        AuthResponse result = authService.login(authRequest); //cookie session 발급

        HttpSession session = request.getSession(); // 신규 세션 생성, JSessionId 쿠키 발급
        session.setAttribute("LOGIN_DIRECTOR", result.getId()); //서버 메모리에 세션 저장
        return "로그인 성공";
    }

    @PostMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false); // 로그인하지 않으면 http세션이 널값으로 반환
        if (session != null) { //로그인이 되면
            session.invalidate(); //세션 데이터 삭제
        }
        return "로그아웃 성공";
    }
}
