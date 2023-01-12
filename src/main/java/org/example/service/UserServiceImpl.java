package org.example.service;

import lombok.AllArgsConstructor;
import org.example.domain.user.User;
import org.example.dto.user.UserResponseDto;
import org.example.dto.user.UserSaveRequestDto;
import org.example.dto.user.UserUpdateRequestDto;
import org.example.repository.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl {
    private final UserMapper userMapper;

    public void save(UserSaveRequestDto requestDto){
        userMapper.create(requestDto.toEntity());
    }
    public void update(Integer uid, UserUpdateRequestDto requestDto){
        User user = userMapper.getUserById(uid);
        userMapper.update(user.update(requestDto.getName(), requestDto.getEmail()));
    }
    public void updatePW(Integer uid, UserUpdateRequestDto requestDto){
        User user = userMapper.getUserById(uid);
        userMapper.update(user.updatePw(requestDto.getUser_pw()));
    }
    public void delete(Integer uid){
        User user  = userMapper.getUserById(uid);
        userMapper.delete(user);
    }
    public UserResponseDto findById(Integer uid){
        User user = userMapper.getUserById(uid);
        return new UserResponseDto(user);
    }
    @Transactional(readOnly = true)
    public List<UserResponseDto> findAllDesc(){
        return userMapper.findAllDesc().stream()
                .map(UserResponseDto::new)
                .collect(Collectors.toList());
    }
}
