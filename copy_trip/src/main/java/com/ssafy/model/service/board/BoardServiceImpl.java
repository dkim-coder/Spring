package com.ssafy.model.service.board;

import com.ssafy.model.dao.board.IBoardDAO;
import com.ssafy.model.dto.board.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements IBoardService {

    private final IBoardDAO boardDAO;

    // 게시글 등록 (SFR-011, SFR-013)
    public int addBoard(Board board) {
        return boardDAO.addBoard(board);
    }

    // 전체 게시글 조회
    public List<Board> getAllBoards() {
        return boardDAO.getAllBoards();
    }

    // 게시글 수정
    public int updateBoard(Board board) {
        return boardDAO.updateBoard(board);
    }

    // 게시글 삭제
    public int deleteBoard(int no) {
        return boardDAO.deleteBoard(no);
    }
}
