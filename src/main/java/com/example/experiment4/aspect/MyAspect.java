package com.example.experiment4.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@Component
@Aspect
public class MyAspect {
    @Around("execution(* com.example..*.buy*(..))")
    //@Around("execution(* com.example..*.buy*(..))")
    public Object calculateExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.nanoTime();
        Object result = joinPoint.proceed();
        long end = System.nanoTime();
        long time = end - start;
        System.out.println("方法：" + joinPoint.getSignature().getName() + "()的执行时间：" + time);
        return result;
    }

    @Around("@within(myInterceptor) || @annotation(myInterceptor)")
    public Object interecptorTarget(ProceedingJoinPoint joinPoint, MyInterceptor myInterceptor) throws Throwable {
        Optional.ofNullable(myInterceptor)
                .or(() -> {
                    MyInterceptor m =
                            joinPoint.getTarget().getClass().getAnnotation(MyInterceptor.class);
                    return Optional.of(m);
                })
                .ifPresent(m -> {
                    for (MyInterceptor.AuthorityType t : m.value()) {
                        System.out.println("当前执行方法的权限："+ t);
                    }
                });
        return joinPoint.proceed();
    }
}
