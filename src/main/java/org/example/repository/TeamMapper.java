package org.example.repository;

import org.apache.ibatis.annotations.Mapper;
import org.example.domain.team.Team;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamMapper {
    Team getTeamById(Integer id);
    void create(Team team);
    void delete(Team team);
    void update(Team team);

    List<Team> findAllDesc();
}
