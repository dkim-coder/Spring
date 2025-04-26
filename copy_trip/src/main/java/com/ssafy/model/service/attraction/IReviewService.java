package com.ssafy.model.service.attraction;

import com.ssafy.model.dto.attraction.Review;

import java.util.List;

public interface IReviewService {

    /**
     * 리뷰 등록 (SFR-004)
     *
     * @param review
     * @return
     */
    public int addReview(Review review);

    /**
     * 특정 관광지에 대한 리뷰 조회 (SFR-007)
     *
     * @param attractionsNo
     * @return
     */
    public List<Review> getReviewsByAttraction(int attractionsNo);

    /**
     * 리뷰 수정 (SFR-009)
     *
     * @param review
     * @return
     */
    public int updateReview(Review review);

    /**
     * 리뷰 삭제 (SFR-009)
     *
     * @param attractionsNo
     * @param userNo
     * @return
     */
    public int deleteReview(int attractionsNo, int userNo);
}
