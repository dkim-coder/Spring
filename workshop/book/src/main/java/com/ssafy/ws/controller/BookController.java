package com.ssafy.ws.controller;

import com.ssafy.ws.dto.Book;
import com.ssafy.ws.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {

    private final BookService service;

    @PostMapping("/regist")
    private ResponseEntity<String> regist(Book book, Model model) {
        String message = null;
        try {
            service.insert(book);
            message = "success";
            return ResponseEntity.status(HttpStatus.CREATED).body(message);
        } catch (SQLException e) {
            message = e.getMessage();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(message);
        }
    }

    @GetMapping("/view/{isbn}")
    private ResponseEntity<?> view(@PathVariable String isbn) {
        try {
            Book book = service.findByIsbn(isbn);
            return ResponseEntity.status(HttpStatus.OK).body(book);
        } catch (SQLException e) {
            String message = e.getMessage();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(message);
        }
    }

    @GetMapping("/list")
    private ResponseEntity<?> list() {
        //입력값 검증 -> service 호출(->dao 호출) -> 일정scope에 저장 -> view select
        try {
            List<Book> books = service.select();
            return ResponseEntity.status(HttpStatus.OK).body(books);
        } catch (SQLException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
