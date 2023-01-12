package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.user.UserResponseDto;
import org.example.dto.user.UserSaveRequestDto;
import org.example.dto.user.UserUpdateRequestDto;
import org.example.service.UserServiceImpl;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserApiController {
    private final UserServiceImpl userService;
    @PostMapping()
    public void save(@RequestBody UserSaveRequestDto requestDto){
        userService.save(requestDto);
    }
    @PutMapping("/{id}")
    public void update(@PathVariable Integer id, @RequestBody UserUpdateRequestDto requestDto){
        userService.update(id,requestDto);
    }
    @DeleteMapping("/{id}")
    public int delete(@PathVariable Integer id){
        userService.delete(id);
        return id;
    }
    @GetMapping("/{id}")
    public UserResponseDto findById(@PathVariable Integer id){
        return userService.findById(id);
    }
}
