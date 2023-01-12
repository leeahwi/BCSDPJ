package org.example.dto.user;

import lombok.Getter;
import org.example.domain.user.User;

@Getter
public class UserResponseDto {
    private Integer uid;
    private String name;
    private String email;

    public UserResponseDto(User entity) {
        this.uid = entity.getUid();
        this.name = entity.getName();
        this.email = entity.getEmail();
    }
}
