package com.ssafy.model.service.attraction;

import com.ssafy.model.dao.attraction.IAttractionDAO;
import com.ssafy.model.dto.attraction.Attraction;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AttractionServiceImpl implements IAttractionService {

    private final IAttractionDAO dao;
    private double recommandCoursesDistance;

    public int addAttraction(Attraction attraction) {
        return dao.addAttraction(attraction);
    }

    // Haversine 공식: 위도/경도로 거리 계산 (단위: km)
    public double haversine(BigDecimal lat1, BigDecimal lon1, BigDecimal lat2, BigDecimal lon2) {
        final double R = 6371.0; // 지구 반지름 (km)

        double lat1d = lat1.doubleValue();
        double lon1d = lon1.doubleValue();
        double lat2d = lat2.doubleValue();
        double lon2d = lon2.doubleValue();

        double dLat = Math.toRadians(lat2d - lat1d);
        double dLon = Math.toRadians(lon2d - lon1d);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) + Math.cos(Math.toRadians(lat1d))
                * Math.cos(Math.toRadians(lat2d)) * Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return R * c;
    }

    public List<String> getRecommandCourses(List<Attraction> list) {
        List<String> recommandCities = new ArrayList<>();
        this.recommandCoursesDistance = 0;

        if (list == null || list.size() <= 1) {
            // 도시가 1개 이하일 경우 그대로 처리
            for (Attraction attraction : list) {
                recommandCities.add(attraction.getTitle()); // or a.getNo().toString()
            }
            return recommandCities;
        }

        int n = list.size();
        boolean[] visited = new boolean[n];
        List<Attraction> route = new ArrayList<>();

        visited[0] = true; // 0번 도시부터 시작
        route.add(list.get(0));
        int current = 0;

        for (int step = 1; step < n; step++) {
            int nextCity = -1;
            double minDist = Double.MAX_VALUE;

            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    double dist = haversine(list.get(current).getLatitude(), list.get(current).getLongitude(),
                            list.get(i).getLatitude(), list.get(i).getLongitude());
                    if (dist < minDist) {
                        minDist = dist;
                        nextCity = i;
                    }
                }
            }

            visited[nextCity] = true;
            route.add(list.get(nextCity));
            this.recommandCoursesDistance += minDist;
            current = nextCity;
        }

        // 추천 코스로 이름만 추출
        for (Attraction attraction : route) {
            recommandCities.add(attraction.getTitle()); // 또는 getNo().toString()
        }

        return recommandCities;
    }

    public double getRecommandCoursesDistance() {
        return this.recommandCoursesDistance;
    }

    public List<Attraction> getAttractionsByAreaAndType(int areaCode, int contentTypeId) {
        return dao.getAttractionsByAreaAndType(areaCode, contentTypeId);
    }

    public int updateAttraction(Attraction attraction) {
        return dao.updateAttraction(attraction);
    }

    public int deleteAttraction(int no) {
        return dao.deleteAttraction(no);
    }

    public Attraction getAttractionDetail(int no) throws Exception {
        return dao.getAttractionByNo(no);
    }

}
