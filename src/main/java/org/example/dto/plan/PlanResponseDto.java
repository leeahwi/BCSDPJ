package org.example.dto.plan;

import io.swagger.models.auth.In;
import lombok.Getter;
import org.example.domain.plan.Plan;


import java.time.LocalDateTime;
@Getter
public class PlanResponseDto {
    private Integer pid;
    private String title;

    private String memo;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    private LocalDateTime replanTime;

    private Integer teamId;
    private Integer userId;

    public PlanResponseDto(Plan entity) {
        this.pid = entity.getPid();
        this.title = entity.getTitle();
        this.startTime = entity.getStartTime();
        this.endTime = entity.getEndTime();
        this.replanTime = entity.getReplanTime();
        this.teamId = entity.getTeamId();
        this.userId = entity.getUserId();
        this.memo = entity.getMemo();
    }
}
