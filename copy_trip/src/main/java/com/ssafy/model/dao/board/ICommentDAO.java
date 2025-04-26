package com.ssafy.model.dao.board;

import com.ssafy.model.dto.board.Comment;

import java.util.List;

public interface ICommentDAO {
    /**
     * comment 추가
     *
     * @param comment
     * @return
     */
    public int addComment(Comment comment);

    /**
     * 게시글에 작성된 comment 조회
     *
     * @param boardNo
     * @return
     */
    public List<Comment> getCommentsByBoard(int boardNo);

    /**
     * comment 업데이트
     *
     * @param comment
     * @return
     */
    public int updateComment(Comment comment);

    /**
     * 게시글에 작성된 comment 삭제
     *
     * @param boardNo
     * @param userNo
     * @return
     */
    public int deleteComment(int boardNo, int userNo);
}
