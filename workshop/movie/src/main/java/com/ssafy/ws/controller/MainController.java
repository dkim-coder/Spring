package com.ssafy.ws.controller;

import com.ssafy.ws.service.MovieService;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.ws.dto.Movie;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
@RequestMapping("/main")
public class MainController {
    private final MovieService service;

    @GetMapping("/list")
    private String list(Model model) {
        String nextPage = null;
        try {
            List<Movie> movies = service.selectAllMovies();
            model.addAttribute("movies", movies);
            nextPage = "list";
        } catch (SQLException e) {
            model.addAttribute("message", e.getMessage());
            nextPage = "index";
        }

        return nextPage;
    }

    @GetMapping("/regist")
    private String regist() {
        return "regist";
    }

    @PostMapping("/regist")
    private String regist(Movie movie, Model model) {
        String nextPage = null;
        try {
            service.insertMovie(movie);
            model.addAttribute("movie", movie);
            nextPage = "redirect:/list";
        } catch (SQLException e) {
            model.addAttribute("message", e.getMessage());
            nextPage = "index";
        }
        return nextPage;
    }
}