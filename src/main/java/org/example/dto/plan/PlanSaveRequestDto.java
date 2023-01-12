package org.example.dto.plan;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.domain.plan.Plan;
import org.example.domain.team.Team;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlanSaveRequestDto {
    private Integer pid;
    private String title;

    private String memo;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    private LocalDateTime replanTime;

    public Plan toEntity(){
        return Plan.builder()
                .pid(pid)
                .title(title)
                .memo(memo)
                .startTime(startTime)
                .endTime(endTime)
                .replanTime(replanTime)
                .build();
    }
}
