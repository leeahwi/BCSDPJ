package org.example.domain.plan;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.domain.user.User;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Plan {
    private Integer pid;
    private String title;

    private String memo;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    private LocalDateTime replanTime;

    private Integer teamId;
    private Integer userId;

    public Plan updateTime(LocalDateTime newStart, LocalDateTime newEnd){
        this.startTime = newStart;
        this.endTime = newEnd;
        return this;
    }
    public Plan updateMemo(String newMemo){
        this.memo = newMemo;
        return this;
    }
}
