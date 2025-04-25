package com.ssafy.ws.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class User {
    private String email;
    private String name;
    private String password;
    private String recId;

    @Builder
    public User(String email, String name, String password) {
        this(email, name, password, null);
    }
}
