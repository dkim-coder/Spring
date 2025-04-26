package com.ssafy.model.dao.attraction;

import com.ssafy.model.dto.attraction.PreferredAttraction;

import java.util.List;

public interface IPreferredAttractionDAO {
    /**
     * 즐겨찾기 attraction 추가
     *
     * @param pa
     * @return
     */
    public int addPreferredAttraction(PreferredAttraction pa);

    /**
     * attraction 삭제
     *
     * @param userNo
     * @param attractionsNo
     * @return
     */
    public int deletePreferredAttraction(int userNo, int attractionsNo);

    /**
     * 유저가 등록한 즐겨찾기 attraction 조회
     *
     * @param userNo
     * @return
     */
    public List<Integer> getPreferredAttractionsByUser(int userNo);
}
