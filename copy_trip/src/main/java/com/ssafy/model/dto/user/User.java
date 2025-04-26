package com.ssafy.model.dto.user;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@ToString
public class User {
    private Long no;
    private String id;
    private String password;
    private String user_name;
    private String email;
    private String nickname;
    private String image;
    private String authority;
}
