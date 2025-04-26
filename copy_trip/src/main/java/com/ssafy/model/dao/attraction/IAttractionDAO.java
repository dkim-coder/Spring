package com.ssafy.model.dao.attraction;

import com.ssafy.model.dto.attraction.Attraction;

import java.sql.SQLException;
import java.util.List;

public interface IAttractionDAO {
    /**
     * 관광지 등록
     *
     * @param attraction
     * @return
     */
    public int addAttraction(Attraction attraction);

    /**
     * 특정 시도(area_code)와 콘텐츠타입(content_type_id)에 따른 관광지 조회
     *
     * @param areaCode
     * @param contentTypeId
     * @return
     */
    public List<Attraction> getAttractionsByAreaAndType(int areaCode, int contentTypeId);

    /**
     * 관광지 정보 수정: 예제에서는 제목(title)만 업데이트
     *
     * @param attraction
     * @return
     */
    public int updateAttraction(Attraction attraction);

    /**
     * 관광지 삭제
     *
     * @param no
     * @return
     */
    public int deleteAttraction(int no);

    public Attraction getAttractionByNo(int no) throws SQLException;
}


