package org.example.service;

import lombok.AllArgsConstructor;
import org.example.domain.plan.Plan;
import org.example.domain.plan.PlanAlarmVo;
import org.example.dto.plan.PlanAlarmResponseDto;
import org.example.dto.plan.PlanResponseDto;
import org.example.dto.plan.PlanSaveRequestDto;
import org.example.dto.plan.PlanUpdateRequestDto;
import org.example.repository.PlanMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PlanServiceImpl implements PlanService{
    private final PlanMapper planMapper;

    @Override
    public void save(PlanSaveRequestDto requestDto){
        planMapper.create(requestDto.toEntity());
    }
    @Override
    public void updateMemo(Integer pid, PlanUpdateRequestDto requestDto){
        Plan plan = planMapper.getPlanById(pid);
        planMapper.update(plan.updateMemo(requestDto.getMemo()));
    }
    @Override
    public void updateTime(Integer pid, PlanUpdateRequestDto requestDto){
        Plan plan = planMapper.getPlanById(pid);
        planMapper.update(plan.updateTime(requestDto.getStart_time(),requestDto.getEnd_time()));
    }
    @Override
    public void delete(Integer pid){
        Plan plan  = planMapper.getPlanById(pid);
        planMapper.delete(plan);
    }
    @Override
    public PlanResponseDto findById(Integer pid){
        Plan plan  = planMapper.getPlanById(pid);
        return new PlanResponseDto(plan);
    }
    @Transactional(readOnly = true)
    public List<PlanAlarmResponseDto> findAlarmEmailList(Integer pid) {
        List<PlanAlarmVo> emailList = planMapper.getAlarmPlanUserEmailById(pid);
        return emailList.stream()
                .map(PlanAlarmResponseDto::new)
                .collect(Collectors.toList());

        //email로 보내는 로직
    }

    @Transactional(readOnly = true)
    public List<PlanResponseDto> findAllDesc(){
        return planMapper.findAllDesc().stream()
                .map(PlanResponseDto::new)
                .collect(Collectors.toList());
    }
}
