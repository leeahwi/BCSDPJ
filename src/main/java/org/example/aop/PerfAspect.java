package org.example.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerfAspect {

    @Around("execution(* org.example.controller..*.hello*(..))")
    public void ExeTime(ProceedingJoinPoint joinPoint) throws Throwable
    {
        long beforeTime = System.currentTimeMillis();

        //함수 실행
        joinPoint.proceed();

        long afterTime = System.currentTimeMillis();

        System.out.println(String.format("%s method execute time(ms) : %d",
                joinPoint.getSignature().toShortString(), afterTime - beforeTime));
    }
}