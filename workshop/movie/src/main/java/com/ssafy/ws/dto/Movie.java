package com.ssafy.ws.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Movie {
    private int id;
    private String title;
    private String director;
    private String genre;
    private int runningTime;
}