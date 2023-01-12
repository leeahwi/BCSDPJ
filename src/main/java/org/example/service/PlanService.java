package org.example.service;

import io.swagger.models.auth.In;
import org.example.dto.plan.PlanAlarmResponseDto;
import org.example.dto.plan.PlanResponseDto;
import org.example.dto.plan.PlanSaveRequestDto;
import org.example.dto.plan.PlanUpdateRequestDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PlanService {
    void save(PlanSaveRequestDto requestDto);
    void updateMemo(Integer pid, PlanUpdateRequestDto requestDto);
    void updateTime(Integer pid, PlanUpdateRequestDto requestDto);
    void delete(Integer pid);
    PlanResponseDto findById(Integer pid);
    List<PlanAlarmResponseDto> findAlarmEmailList(Integer pid);


}
