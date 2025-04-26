package com.ssafy.model.dao.board;

import com.ssafy.model.dto.board.Board;

import java.util.List;

public interface IBoardDAO {
    /**
     * 게시글 등록
     *
     * @param board
     * @return
     */
    public int addBoard(Board board);

    /**
     * 전체 게시글 조회
     *
     * @return
     */
    public List<Board> getAllBoards();

    /**
     * 게시글 수정
     *
     * @param board
     * @return
     */
    public int updateBoard(Board board);

    /**
     * 게시글 삭제
     *
     * @param no
     * @return
     */
    public int deleteBoard(int no);
}
