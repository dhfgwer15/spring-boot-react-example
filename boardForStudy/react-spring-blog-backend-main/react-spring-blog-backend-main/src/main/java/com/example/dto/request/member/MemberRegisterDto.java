package com.example.dto.request.member;

import org.springframework.stereotype.Component;

import com.example.common.Role;
import com.example.entity.Member;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * -Request-
 * 회원 가입 요청 dto
 */
@Component
@Getter
@Setter
@NoArgsConstructor
public class MemberRegisterDto {

    private String email;
    private String password;
    private String passwordCheck;
    private String username;
    
    @Builder
    public MemberRegisterDto(String email, String password, String passwordCheck, String username) {
        this.email = email;
        this.password = password;
        this.passwordCheck = passwordCheck;
        this.username = username;
    }

    // DTO -> Entity
    public static Member ofEntity(MemberRegisterDto dto) {
        return Member.builder()
                .email(dto.getEmail())
                .password(dto.getPassword())
                .username(dto.getUsername())
                .roles(Role.USER)
                .build();
    }
}
