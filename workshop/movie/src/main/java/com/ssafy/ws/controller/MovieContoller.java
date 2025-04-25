package com.ssafy.ws.controller;

import com.ssafy.ws.dto.Movie;
import com.ssafy.ws.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping("/movie")
@RequiredArgsConstructor
public class MovieContoller {
    private static int id = 100;
    private final MovieService service;

    @GetMapping("/regist")
    private String registForm() {
        return "movie/regist";
    }

    @PostMapping("/regist")
    private String regist(@ModelAttribute Movie movie, Model model) {

        movie.setId(id++);

        String nextPage = "index";
        try {
            service.insert(movie);

            model.addAttribute("movie", movie);
            model.addAttribute("movieCount", service.getMovieCount());


            nextPage = "movie/regist_result";
        } catch (SQLException e) {
            model.addAttribute("message", e.getMessage());
            nextPage = "error/500";
        }

        return nextPage;
    }

    @GetMapping("/list")
    private String list(Model model) {
        String nextPage = "index";
        try {
            List<Movie> movies = service.select();
            model.addAttribute("movies", movies);
            nextPage = "movie/list";
        } catch (SQLException e) {
            model.addAttribute("message", e.getMessage());
            nextPage = "error/500";
        }

        return nextPage;
    }

}
