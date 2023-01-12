package org.example.domain.user;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserVo {
    public UserVo(String subject, String string, Collection<? extends GrantedAuthority> authorities) {
    }
    private int userNo;
    private String userId;
    private String userPw;
}