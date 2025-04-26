package com.ssafy.model.service.board;

import com.ssafy.model.dto.board.Board;

import java.util.List;

public interface IBoardService {
    public int addBoard(Board board);

    // 전체 게시글 조회
    public List<Board> getAllBoards();

    // 게시글 수정
    public int updateBoard(Board board);

    // 게시글 삭제
    public int deleteBoard(int no);
}
