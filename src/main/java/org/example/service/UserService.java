package org.example.service;

import org.example.dto.user.UserResponseDto;
import org.example.dto.user.UserSaveRequestDto;
import org.example.dto.user.UserUpdateRequestDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    void save(UserSaveRequestDto requestDto);
    void update(Integer uid, UserUpdateRequestDto requestDto);
    void updatePW(Integer uid, UserUpdateRequestDto requestDto);
    void delete(Integer uid);
    UserResponseDto findById(Integer uid);
    List<UserResponseDto> findAllDesc();

}
