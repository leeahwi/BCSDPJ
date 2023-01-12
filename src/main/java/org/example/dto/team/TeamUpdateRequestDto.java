package org.example.dto.team;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class TeamUpdateRequestDto {
    private String name;

    public TeamUpdateRequestDto(String name) {
        this.name = name;
    }
}

