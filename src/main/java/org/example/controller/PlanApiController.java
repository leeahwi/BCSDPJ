package org.example.controller;

import io.swagger.models.auth.In;
import lombok.RequiredArgsConstructor;
import org.example.dto.plan.PlanAlarmResponseDto;
import org.example.dto.plan.PlanResponseDto;
import org.example.dto.plan.PlanSaveRequestDto;
import org.example.dto.plan.PlanUpdateRequestDto;
import org.example.service.EmailServiceImpl;
import org.example.service.PlanServiceImpl;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/plan")
public class PlanApiController {
    private final PlanServiceImpl planService;
    private final EmailServiceImpl emailService;
    @PostMapping()
    public void save(@RequestBody PlanSaveRequestDto requestDto){
        planService.save(requestDto);
    }
    @PutMapping("/memo/{id}")
    public void updateMemo(@PathVariable Integer id, @RequestBody PlanUpdateRequestDto requestDto){
        planService.updateMemo(id,requestDto);
    }
    @PutMapping("/time/{id}")
    public void updateTime(@PathVariable Integer id, @RequestBody PlanUpdateRequestDto requestDto){
        planService.updateTime(id,requestDto);
    }
    @DeleteMapping("/{id}")
    public int delete(@PathVariable Integer id){
        planService.delete(id);
        return id;
    }
    @GetMapping("/{id}")
    public PlanResponseDto findById(@PathVariable Integer id){
        return planService.findById(id);
    }

    @Scheduled(cron = "0 0 0 * * *")    //매일 자정
    @PostMapping("/alarm/{id}")
    public void alarmPlan(@PathVariable Integer id){
        planService.findAlarmEmailList(id).stream()
                .forEach(x->emailService.sendAlarmMessage(x.getEmail(),"PlanAlarm"));
    }
}
