package com.ssafy.model.dao.attraction;

import com.ssafy.model.dto.attraction.Review;

import java.util.List;

public interface IReviewDAO {
    /**
     * 리뷰 등록: 성공 시 영향을 받은 행 수(보통 1)를 반환
     *
     * @param review
     * @return
     */
    public int addReview(Review review);

    /**
     * 리뷰 수정: 성공 시 영향을 받은 행 수를 반환
     *
     * @param attractionsNo
     * @return
     */
    public List<Review> getReviewsByAttraction(int attractionsNo);

    /**
     * 리뷰 수정: 성공 시 영향을 받은 행 수를 반환
     *
     * @param review
     * @return
     */
    public int updateReview(Review review);

    /**
     * 리뷰 삭제: 성공 시 영향을 받은 행 수를 반환
     *
     * @param attractionsNo
     * @param userNo
     * @return
     */
    public int deleteReview(int attractionsNo, int userNo);
}
