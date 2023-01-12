package org.example.service;

import org.example.dto.team.TeamResponseDto;
import org.example.dto.team.TeamSaveRequestDto;
import org.example.dto.team.TeamUpdateRequestDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TeamService {
    void save(TeamSaveRequestDto requestDto);
    void updateName(Integer tid, TeamUpdateRequestDto requestDto);
    void delete(Integer tid);
    TeamResponseDto findById(Integer tid);
    List<TeamResponseDto> findAllDesc();

}
