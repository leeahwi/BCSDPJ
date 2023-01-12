package org.example.dto.user;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserUpdateRequestDto {
    private String name;
    private String email;
    private String user_pw;

    public UserUpdateRequestDto(String name, String email, String user_pw) {
        this.name = name;
        this.email = email;
        this.user_pw = user_pw;
    }
}

