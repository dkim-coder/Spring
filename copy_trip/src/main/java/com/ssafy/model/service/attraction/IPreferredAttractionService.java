package com.ssafy.model.service.attraction;

import com.ssafy.model.dto.attraction.PreferredAttraction;

import java.util.List;

public interface IPreferredAttractionService {
    public int addPreferredAttraction(PreferredAttraction pa);

    public int deletePreferredAttraction(int userNo, int attractionsNo);

    public List<Integer> getPreferredAttractionsByUser(int userNo);
}
