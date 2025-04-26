package com.ssafy.controller;

import com.ssafy.model.dto.board.Board;
import com.ssafy.model.service.board.IBoardService;
import jakarta.servlet.http.HttpServlet;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/boards")
public class BoardController extends HttpServlet {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private final IBoardService boardService;

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Board>> getAllBoards() {
        try {
            List<Board> boards = boardService.getAllBoards();
            return ResponseEntity.ok(boards);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<Integer> addBoard(@RequestBody Board board) {
        try {
            int boardNo = boardService.addBoard(board);
            return ResponseEntity.status(HttpStatus.CREATED).body(boardNo);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{no}")
    @ResponseBody
    public ResponseEntity<Boolean> updateBoard(@PathVariable int no, @RequestBody Board board) {
        try {
            board.setNo(no);
            int result = boardService.updateBoard(board);
            return ResponseEntity.ok(result > 0);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{no}")
    @ResponseBody
    protected ResponseEntity<Boolean> deleteBoard(@PathVariable int no) {
        // 게시글 삭제: /boards/{no}
        try {
            int result = boardService.deleteBoard(no);
            return ResponseEntity.ok(result > 0);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
