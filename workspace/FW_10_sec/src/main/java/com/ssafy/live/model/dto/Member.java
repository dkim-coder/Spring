package com.ssafy.live.model.dto;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class Member {
    private int mno;
    private @NonNull String name;
    private @NonNull String email;
    private @NonNull String password;
    private String role;
    private byte[] profile;
    // 주소 목록
    @Builder.Default
    private List<Address> addresses = new ArrayList<>();

    public Member(int mno, String name, String email, String password, String role) {
        this.mno = mno;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.addresses = new ArrayList<>();
    }

    public String getProfileImg() {
        if (profile != null) {
            return "data:image/jpeg;base64," + Base64.getEncoder().encodeToString(profile);
        } else {
            return "/img/profile.png";
        }
    }

}
