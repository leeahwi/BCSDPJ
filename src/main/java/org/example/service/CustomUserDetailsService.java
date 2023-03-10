package org.example.service;

import lombok.RequiredArgsConstructor;

import org.example.dto.user.UserDTO;
import org.example.global.exception.UserNotFoundException;
import org.example.repository.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@RequiredArgsConstructor
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        return userMapper.findUser(userId)
                .map(user -> addAuthorities(user))
                .orElseThrow(() -> new UserNotFoundException(userId + ">ID를 찾을 수 없습니다."));
    }

    private UserDTO addAuthorities(UserDTO userDTO) {
        userDTO.setAuthorities(Arrays.asList(new SimpleGrantedAuthority(userDTO.getUserRole())));

        return userDTO;
    }
}