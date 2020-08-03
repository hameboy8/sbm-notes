package tw.sian.notes.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {

    @Pointcut("execution(* tw.sian.notes.controller..*(..))")
    public void pointcut(){};

    @Before("pointcut()")
    public void beforePointcut(JoinPoint joinPoint){
        Logger logger = LoggerFactory.getLogger(joinPoint.getTarget().getClass().getName());
        String methodName = joinPoint.getSignature().getName();
        logger.info(methodName + "() start=====");
    }
    @After("pointcut()")
    public void afterPointcut(JoinPoint joinPoint){
        Logger logger = LoggerFactory.getLogger(joinPoint.getTarget().getClass().getName());
        String methodName = joinPoint.getSignature().getName();
        logger.info(methodName + "() end=======");
    }
}
