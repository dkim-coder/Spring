package com.ssafy.model.service.attraction;

import com.ssafy.model.dao.attraction.IReviewDAO;
import com.ssafy.model.dto.attraction.Review;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements IReviewService {

    private final IReviewDAO dao;

    // 리뷰 등록 (SFR-004)
    public int addReview(Review review) {
        return dao.addReview(review);
    }

    // 특정 관광지에 대한 리뷰 조회 (SFR-007)
    public List<Review> getReviewsByAttraction(int attractionsNo) {
        return dao.getReviewsByAttraction(attractionsNo);
    }

    // 리뷰 수정 (SFR-009)
    public int updateReview(Review review) {
        return dao.updateReview(review);
    }

    // 리뷰 삭제 (SFR-009)
    public int deleteReview(int attractionsNo, int userNo) {
        return dao.deleteReview(attractionsNo, userNo);
    }
}
