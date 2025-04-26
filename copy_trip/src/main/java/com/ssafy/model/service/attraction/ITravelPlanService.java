package com.ssafy.model.service.attraction;

import com.ssafy.model.dto.attraction.TravelPlan;

public interface ITravelPlanService {
    public int addTravelPlan(TravelPlan plan);

    public int updateTravelPlan(TravelPlan plan);

    public int deleteTravelPlan(int userNo);

    public TravelPlan getTravelPlanByUser(int userNo);
}
