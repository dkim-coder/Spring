package com.ssafy.model.service.board;

import com.ssafy.model.dto.board.NoticeBoard;

import java.util.List;

public interface INoticeBoardService {
    public int addNotice(NoticeBoard notice);

    public List<NoticeBoard> getAllNotices();

    public int updateNotice(NoticeBoard notice);

    public int deleteNotice(int no);
}
