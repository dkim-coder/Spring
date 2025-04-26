package com.ssafy.model.dto.attraction;

import lombok.*;

import java.math.BigDecimal;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@ToString
public class Attraction {
    private int no;
    private Integer contentId;
    private String title;
    private Integer contentTypeId;
    private Integer areaCode;
    private Integer siGunGuCode;
    private String firstImage1;
    private String firstImage2;
    private Integer mapLevel;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private String tel;
    private String addr1;
    private String addr2;
    private String homepage;
    private String overview;
}
