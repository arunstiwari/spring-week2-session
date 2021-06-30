package com.sapient.springsession.advice;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class LoggingAdvice {
    private static final String POINTCUT = "within(com.sapient.springsession.repository..*)";

//    @Before(POINTCUT)
//    public void logMethodEntryCall(JoinPoint jp){
//        String className = jp.getSignature().getDeclaringTypeName();
//        String methodName = jp.getSignature().getName();
//        Object[] args = jp.getArgs();
//        log.info("Entering class {} within method {} with arguments {}",className,methodName,args);
//    }
//
//    @After(POINTCUT)
//    public void logMethodExitCall(JoinPoint jp){
//        String className = jp.getSignature().getDeclaringTypeName();
//        String methodName = jp.getSignature().getName();
//        log.info("Exiting class {} within method {} ",className,methodName);
//    }

    @Around(POINTCUT)
    public Object logMethodAround(ProceedingJoinPoint jp) throws Throwable {
        log.info("Entering class {} within method {} with arguments {}",
                jp.getSignature().getDeclaringTypeName(),
                jp.getSignature().getName(),
                jp.getArgs());
        Object returnval = jp.proceed();
        log.info("Exiting class {} within method {} with return value {} ",
                jp.getSignature().getDeclaringTypeName(),
                jp.getSignature().getName(),
                returnval);

        return returnval;
    }
}
