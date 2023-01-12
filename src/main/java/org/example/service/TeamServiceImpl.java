package org.example.service;

import lombok.AllArgsConstructor;
import org.example.domain.team.Team;
import org.example.dto.team.TeamResponseDto;
import org.example.dto.team.TeamSaveRequestDto;
import org.example.dto.team.TeamUpdateRequestDto;
import org.example.repository.TeamMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TeamServiceImpl implements TeamService{
    private final TeamMapper teamMapper;

    public void save(TeamSaveRequestDto requestDto){
        teamMapper.create(requestDto.toEntity());
    }
    public void updateName(Integer tid, TeamUpdateRequestDto requestDto){
        Team team = teamMapper.getTeamById(tid);
        teamMapper.update(team.update(requestDto.getName()));
    }
    public void delete(Integer tid){
        Team team = teamMapper.getTeamById(tid);
        teamMapper.delete(team);
    }
    public TeamResponseDto findById(Integer tid){
        Team team = teamMapper.getTeamById(tid);
        return new TeamResponseDto(team);
    }
    @Transactional(readOnly = true)
    public List<TeamResponseDto> findAllDesc(){
        return teamMapper.findAllDesc().stream()
                .map(TeamResponseDto::new)
                .collect(Collectors.toList());
    }
}
