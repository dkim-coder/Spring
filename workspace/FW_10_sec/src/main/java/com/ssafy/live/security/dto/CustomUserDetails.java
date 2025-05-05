package com.ssafy.live.security.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.ssafy.live.model.dto.Member;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
// TODO: 10-1. UserDetails의 확장인 CustomUserDetails를 확인하세요.
public class CustomUserDetails implements UserDetails {

    private @NonNull Member member;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> roles = new ArrayList<>();
        if (member.getRole() != null) {
            // ROLE에 대한 접두사는 ROLE_
            roles.add(new SimpleGrantedAuthority("ROLE_" + member.getRole()));
        }
        return roles;
    }

    @Override
    public String getPassword() {
        return member.getPassword();
    }

    @Override
    public String getUsername() {
        // P.K로 사용되는 정보
        return member.getEmail();
    }
}
