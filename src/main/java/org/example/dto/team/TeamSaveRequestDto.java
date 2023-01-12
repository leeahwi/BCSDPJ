package org.example.dto.team;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.domain.team.Team;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TeamSaveRequestDto {
    private Integer tid;
    private String name;
    private String invite_link;
    private LocalDateTime create_link_date;
    public Team toEntity(){
        return Team.builder()
                .tid(tid)
                .name(name)
                .invite_link(invite_link)
                .create_link_date(create_link_date)
                .build();
    }
}
