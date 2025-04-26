package com.ssafy.model.service.board;

import com.ssafy.model.dao.board.INoticeBoardDAO;
import com.ssafy.model.dto.board.NoticeBoard;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoticeBoardServiceImpl implements INoticeBoardService {

    private final INoticeBoardDAO dao;

    public int addNotice(NoticeBoard notice) {
        return dao.addNotice(notice);
    }

    public List<NoticeBoard> getAllNotices() {
        return dao.getAllNotices();
    }

    public int updateNotice(NoticeBoard notice) {
        return dao.updateNotice(notice);
    }

    public int deleteNotice(int no) {
        return dao.deleteNotice(no);
    }
}
