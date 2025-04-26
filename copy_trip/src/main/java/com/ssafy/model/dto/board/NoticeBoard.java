package com.ssafy.model.dto.board;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@ToString
public class NoticeBoard {
    private int no;
    private String title;
    private String content;
    private LocalDate releaseDate;

}
