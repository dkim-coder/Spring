package com.ssafy.model.dto.board;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@ToString
public class Comment {
    private int boardNo;
    private int userNo;
    private String content;
    private LocalDate releaseDate;

}
