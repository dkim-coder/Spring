package com.ssafy.ws.controller;

import com.ssafy.ws.dto.Book;
import com.ssafy.ws.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLException;
import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/books")
public class BookController {

    private final BookService service;

    @GetMapping("/regist")
    private String registerForm() {
        return "regist";
    }

    @PostMapping("/regist")
    private String regist(Book book, Model model) {
        //입력값 검증 -> service 호출(->dao 호출) -> 일정scope에 저장 -> view select
        String nextPage = null;
        try {
            service.insert(book);
            nextPage = "redirect:/books/list";
        } catch (SQLException e) {
            model.addAttribute("message", e.getMessage());
            nextPage = "error/500";
        }
        return nextPage;
    }

    @GetMapping("/view")
    private String view(String isbn, Model model) {
        //입력값 검증 -> service 호출(->dao 호출) -> 일정scope에 저장 -> view select
        try {
            Book book = service.findByIsbn(isbn);
            model.addAttribute("book", book);
            return "view";

        } catch (SQLException e) {
            model.addAttribute("message", e.getMessage());
            return "error/500";
        }

    }

    @GetMapping("/list")
    private String list(Model model) {
        String nextPage = "index";
        //입력값 검증 -> service 호출(->dao 호출) -> 일정scope에 저장 -> view select
        try {
            List<Book> books = service.select();
            model.addAttribute("books", books);
            nextPage = "list";
        } catch (SQLException e) {
            model.addAttribute("message", e.getMessage());
            nextPage = "error/500";
        }
        return nextPage;
    }

}
