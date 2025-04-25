package com.ssafy.ws.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Book {
    private String isbn;
    private String title;
    private String author;
    private int price;
    private String desc;
    private String img;

    @Builder
    public Book(String isbn, String title, String author, int price, String desc) {
        this(isbn, title, author, price, desc, null);
    }
}
