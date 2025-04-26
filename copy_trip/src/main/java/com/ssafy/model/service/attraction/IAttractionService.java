package com.ssafy.model.service.attraction;

import com.ssafy.model.dto.attraction.Attraction;

import java.util.List;

public interface IAttractionService {
    public double getRecommandCoursesDistance();

    public int addAttraction(Attraction attraction);

    public List<Attraction> getAttractionsByAreaAndType(int areaCode, int contentTypeId);

    public int updateAttraction(Attraction attraction);

    public int deleteAttraction(int no);

    public Attraction getAttractionDetail(int no) throws Exception;

    public List<String> getRecommandCourses(List<Attraction> list);
}
