package com.ssafy.model.dto.attraction;

import lombok.*;

// 관광지 경로 – preferred_plan 테이블
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@ToString
public class TravelPlan {
    private int userNo;
    private String plans; // 예: 여러 관광지 번호나 경로 정보를 문자열로 저장
}
