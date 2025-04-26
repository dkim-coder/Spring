package com.ssafy.model.service.attraction;

import com.ssafy.model.dao.attraction.ITravelPlanDAO;
import com.ssafy.model.dto.attraction.TravelPlan;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TravelPlanServiceImpl implements ITravelPlanService {
    private final ITravelPlanDAO dao;

    public int addTravelPlan(TravelPlan plan) {
        return dao.addTravelPlan(plan);
    }

    public int updateTravelPlan(TravelPlan plan) {
        return dao.updateTravelPlan(plan);
    }

    public int deleteTravelPlan(int userNo) {
        return dao.deleteTravelPlan(userNo);
    }

    public TravelPlan getTravelPlanByUser(int userNo) {
        return dao.getTravelPlanByUser(userNo);
    }
}
