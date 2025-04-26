package com.ssafy.model.service.board;

import com.ssafy.model.dao.board.ICommentDAO;
import com.ssafy.model.dto.board.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements ICommentService {

    private final ICommentDAO dao;

    public int addComment(Comment comment) {
        return dao.addComment(comment);
    }

    public List<Comment> getCommentsByBoard(int boardNo) {
        return dao.getCommentsByBoard(boardNo);
    }

    public int updateComment(Comment comment) {
        return dao.updateComment(comment);
    }

    public int deleteComment(int boardNo, int userNo) {
        return dao.deleteComment(boardNo, userNo);
    }
}
