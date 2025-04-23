package com.ssafy.ws.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class HomeController{

	@GetMapping({"/", "/home"})
	public String home() {
		// TODO Auto-generated method stub
		return "index";
	}

}
