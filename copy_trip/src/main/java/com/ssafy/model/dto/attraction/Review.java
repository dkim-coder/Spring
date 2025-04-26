package com.ssafy.model.dto.attraction;

import lombok.*;

import java.time.LocalDate;


@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@ToString
public class Review {
    private int attractionsNo;
    private int rating;
    private String comment;
    private int userNo;
    private LocalDate releaseDate;
}
