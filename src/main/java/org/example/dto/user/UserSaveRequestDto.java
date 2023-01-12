package org.example.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.domain.user.User;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserSaveRequestDto {
    private Integer uid;
    private String name;
    private String email;

    private String user_id;
    private String user_pw;

    public User toEntity(){
        return User.builder()
                .uid(uid)
                .name(name)
                .email(email)
                .userId(user_id)
                .userPw(user_pw)
                .build();
    }
}
