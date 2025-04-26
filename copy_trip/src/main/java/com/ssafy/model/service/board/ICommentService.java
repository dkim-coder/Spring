package com.ssafy.model.service.board;

import com.ssafy.model.dto.board.Comment;

import java.util.List;

public interface ICommentService {
    public int addComment(Comment comment);

    public List<Comment> getCommentsByBoard(int boardNo);

    public int updateComment(Comment comment);

    public int deleteComment(int boardNo, int userNo);

}
