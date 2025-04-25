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
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;


    @GetMapping("/signup")
    private String signupForm() {
        return "users/signupForm";
    }

    @GetMapping("/signin")
    private String signinForm() {
        return "users/signinForm";
    }

    @PostMapping("/signup")
    private String signup(@ModelAttribute User user, Model model) {
        try {
            service.createUser(user);
            return "redirect:/";
        } catch (SQLException e) {
            model.addAttribute("message", e.getMessage());
            return "error/500";
        }
    }

    @PostMapping("/signin")
    private String signin(
            @RequestParam String email,
            @RequestParam String password,
            @RequestParam(required = false) String rememberMe,
            Model model, HttpSession session,
            HttpServletResponse response) {

        String next = "index";

        try {
            User user = service.loginCheck(email);
            if (BCrypt.checkpw(password.trim(), user.getPassword())) {
                session.setAttribute("loginUser", user);

                if (rememberMe != null) {
                    Cookie cookie = new Cookie("rememberMe", email);
                    cookie.setMaxAge(24 * 60 * 60);
                    response.addCookie(cookie);
                } else {
                    Cookie cookie = new Cookie("rememberMe", "");
                    response.addCookie(cookie);
                }
                next = "redirect:/";
            }
        } catch (SQLException e) {
            model.addAttribute("alertMsg", "아이디 비밀번호 확인");
            next = "error/500";
        }
        return next;
    }

    @GetMapping("/signout")
    private String signout(HttpSession session) {

        if (session == null || session.getAttribute("loginUser") == null
                || session.getAttribute("loginUser").equals("")) {
            return "redirect:/";
        } else {
            session.invalidate();
            return "redirect:/";
        }

    }

}
