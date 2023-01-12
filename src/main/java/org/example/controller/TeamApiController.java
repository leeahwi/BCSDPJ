package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.team.TeamResponseDto;
import org.example.dto.team.TeamSaveRequestDto;
import org.example.dto.team.TeamUpdateRequestDto;
import org.example.service.TeamServiceImpl;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/team")
public class TeamApiController {
    private final TeamServiceImpl teamService;
    @PostMapping()
    public void save(@RequestBody TeamSaveRequestDto requestDto){
        teamService.save(requestDto);
    }
    @PutMapping("/{id}")
    public void update(@PathVariable Integer id, @RequestBody TeamUpdateRequestDto requestDto){
        teamService.updateName(id,requestDto);
    }
    @DeleteMapping("/{id}")
    public int delete(@PathVariable Integer id){
        teamService.delete(id);
        return id;
    }
    @GetMapping("/{id}")
    public TeamResponseDto findById(@PathVariable Integer id){
        return teamService.findById(id);
    }
}
