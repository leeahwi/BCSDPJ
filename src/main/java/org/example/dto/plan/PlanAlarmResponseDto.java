package org.example.dto.plan;

import lombok.Getter;
import org.example.domain.plan.PlanAlarmVo;

@Getter
public class PlanAlarmResponseDto {
    private String email;

    public PlanAlarmResponseDto(PlanAlarmVo entity) {
        this.email = entity.getEmail();
    }
}
