package org.example.dto.team;

import lombok.Getter;
import org.example.domain.team.Team;

import java.time.LocalDateTime;

@Getter
public class TeamResponseDto {
    private Integer tid;
    private String name;
    private String inviteLink;
    private LocalDateTime createLinkDate;

    public TeamResponseDto(Team entity) {
        this.tid = entity.getTid();
        this.name = entity.getName();
        this.inviteLink = entity.getInvite_link();
        this.createLinkDate = entity.getCreate_link_date();
    }
}
