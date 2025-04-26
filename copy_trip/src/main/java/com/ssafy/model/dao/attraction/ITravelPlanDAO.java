package com.ssafy.model.dao.attraction;

import com.ssafy.model.dto.attraction.TravelPlan;

public interface ITravelPlanDAO {
    /**
     * 여행 계획 추가
     *
     * @param plan
     * @return
     */
    public int addTravelPlan(TravelPlan plan);

    /**
     * 여행 계획 업데이트
     *
     * @param plan
     * @return
     */
    public int updateTravelPlan(TravelPlan plan);

    /**
     * 여행 계획 삭제
     *
     * @param planNo
     * @return
     */
    public int deleteTravelPlan(int planNo);

    /**
     * 유저의 여행 계획 조회
     *
     * @param userNo
     * @return
     */
    public TravelPlan getTravelPlanByUser(int userNo);
}
