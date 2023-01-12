
package org.example.dto.plan;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class PlanUpdateRequestDto {
    private String title;
    private String memo;
    private LocalDateTime start_time;
    private LocalDateTime end_time;

    private LocalDateTime replan_time;
    public PlanUpdateRequestDto(String title, String memo, LocalDateTime start_time, LocalDateTime end_time, LocalDateTime replan_time) {
        this.title = title;
        this.memo = memo;
        this.start_time = start_time;
        this.end_time = end_time;
        this.replan_time = replan_time;
    }
}

