package com.ssafy.ws.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Movie {
    private int id;
    private String title;
    private String director;
    private String genre;
    private int runningTime;
}