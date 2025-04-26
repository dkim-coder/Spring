package com.ssafy.controller;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Servlet implementation class MainServlet
 */
@Controller
@NoArgsConstructor
@RequestMapping("/main")
public class MainController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @GetMapping
    public String handleGet(HttpServletRequest request) {
        return "Served at: " + request.getContextPath();
    }

    @PostMapping
    public String handlePost(HttpServletRequest request) {
        return handleGet(request); // 동일하게 처리하고 싶으면 이렇게!
    }

}
