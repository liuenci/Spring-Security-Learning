package com.liuencier.web.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Date;

@Aspect
@Component
public class TimeAspect {

    @Around("execution(* com.liuencier.web.controller.UserController.*(..))")
    public Object handleControllerMethod(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("===== Aspect 执行开始 =====");
        Object[] args = pjp.getArgs();
        for (int i = 0; i < args.length; i++){
            System.out.println("===== 第 " + i + " 参数的值为"+args[i] + " =====");
        }

        Object object = pjp.proceed();

        System.out.println("===== Aspect 执行结束 =====");

        return object;
    }
}
