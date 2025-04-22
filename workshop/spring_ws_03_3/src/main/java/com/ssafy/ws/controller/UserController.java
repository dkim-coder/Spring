package com.ssafy.ws.controller;

import com.ssafy.ws.model.dto.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {

    @PostMapping("/login")
    public String doLogin(HttpSession session, @ModelAttribute User user, Model model) {
        if (user.getId().equals("ssafy") && user.getPass().equals("1234")) {
            user.setName("김싸피");
            session.setAttribute("loginUser", user);
        } else {
            model.addAttribute("alertMsg", "로그인 실패");
        }

        return "redirect:/index";
    }

    @GetMapping("/logout")
    public String doLogout(HttpSession session) {
        session.invalidate();
        return "redirect:/index";
    }
}
