package com.ssafy.model.service.attraction;

import com.ssafy.model.dao.attraction.IPreferredAttractionDAO;
import com.ssafy.model.dto.attraction.PreferredAttraction;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PreferredAttractionServiceImpl implements IPreferredAttractionService {

    private final IPreferredAttractionDAO dao;

    public int addPreferredAttraction(PreferredAttraction pa) {
        return dao.addPreferredAttraction(pa);
    }

    public int deletePreferredAttraction(int userNo, int attractionsNo) {
        return dao.deletePreferredAttraction(userNo, attractionsNo);
    }

    public List<Integer> getPreferredAttractionsByUser(int userNo) {
        return dao.getPreferredAttractionsByUser(userNo);
    }
}
