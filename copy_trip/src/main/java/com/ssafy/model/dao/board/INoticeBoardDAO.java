package com.ssafy.model.dao.board;

import com.ssafy.model.dto.board.NoticeBoard;

import java.util.List;

public interface INoticeBoardDAO {
    /**
     * 알람 보드 추가
     *
     * @param notice
     * @return
     */
    public int addNotice(NoticeBoard notice);

    /**
     * 알람 보드들 조회
     *
     * @return
     */
    public List<NoticeBoard> getAllNotices();

    /**
     * 알람 보드 업데이트
     *
     * @param notice
     * @return
     */
    public int updateNotice(NoticeBoard notice);

    /**
     * 알람 삭제
     *
     * @param no
     * @return
     */
    public int deleteNotice(int no);
}
