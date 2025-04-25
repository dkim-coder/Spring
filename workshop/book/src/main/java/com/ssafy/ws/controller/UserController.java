package com.ssafy.ws.controller;

import com.ssafy.ws.dto.User;
import com.ssafy.ws.service.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;

@Controller
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService service;

    @GetMapping("/signin")
    private String signinForm() {
        return "users/signinForm";
    }

    @GetMapping("/signup")
    private String signupForm() {
        return "users/signupForm";
    }

    @GetMapping("/signout")
    private String signout(HttpSession session) {
        String nextPage = "index";
        if (session == null ||
                session.getAttribute("loginUser") == null || session.getAttribute("loginUser").equals("")) {
        } else {
            session.invalidate();
        }
        return nextPage;
    }

    @PostMapping("/signin")
    private String signin(HttpSession session,
                          HttpServletResponse response,
                          Model model,
                          String email, String password, @RequestParam(defaultValue = "") String rememberMe) {

        String nextPage = "index";
        //rememberMe 데이터가 on인 경우  Cookie생성 "rememberMe"에 email 저장 response.addCookie(cookie)
        try {
            User user = service.loginCheck(email);
//			if(user.getPass().equals(password)) {
            if (BCrypt.checkpw(password, user.getPassword())) {
                session.setAttribute("loginUser", user);
                //id checked
                if (rememberMe.equals("on")) {
                    Cookie cookie = new Cookie("rememberMe", email);
                    cookie.setMaxAge(24 * 60 * 60);
                    response.addCookie(cookie);
                } else { //id unchecked
                    Cookie cookie = new Cookie("rememberMe", "");
                    response.addCookie(cookie);
                }

            } else {
                model.addAttribute("alertMsg", "아디디비밀번호 확인 하세요.");
            }

        } catch (SQLException e) {
            model.addAttribute("message", e.getMessage());
            nextPage = "error/500";
        }

        return nextPage;
    }

    @PostMapping("/signup")
    private String signup(User user, Model model) {
        //request data check -> service(-dao) -> 일정 scope data 저장->view select
        String nextPage = "index";

        try {
            service.createUser(user);

        } catch (SQLException e) {
            model.addAttribute("message", e.getMessage());
            nextPage = "error/500";
        }
        return nextPage;
    }
}
