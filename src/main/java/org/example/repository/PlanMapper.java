package org.example.repository;

import org.apache.ibatis.annotations.Mapper;
import org.example.domain.plan.Plan;
import org.example.domain.plan.PlanAlarmVo;
import org.example.dto.plan.PlanAlarmResponseDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlanMapper {
    Plan getPlanById(Integer id);
    void create(Plan plan);
    void delete(Plan plan);
    void update(Plan plan);

    List<PlanAlarmVo> getAlarmPlanUserEmailById(Integer id);

    List<Plan> findAllDesc();
}
