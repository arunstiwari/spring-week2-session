package com.sapient.springsession.advice;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Slf4j
@Aspect
@Component
public class LoggingAdvice {
    private static final String POINTCUT = "execution(public * com.sapient.springsession.repository.ProductRepository.*(..))";
    private static final String POINTCUT1 = "@annotation(com.sapient.springsession.annotation.LogExecutionTime)";

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

//    @Around(POINTCUT)
//    public Object logMethodAround(ProceedingJoinPoint jp) throws Throwable {
//        log.info("Entering class {} within method {} with arguments {}",
//                jp.getSignature().getDeclaringTypeName(),
//                jp.getSignature().getName(),
//                jp.getArgs());
//         long start = System.nanoTime();
//        Object returnval = jp.proceed();
//        long end = System.nanoTime();
//        log.info("Execution time was {} in ms", TimeUnit.NANOSECONDS.toMillis(end-start));
//        log.info("Exiting class {} within method {} with return value {} ",
//                jp.getSignature().getDeclaringTypeName(),
//                jp.getSignature().getName(),
//                returnval);
//
//        return returnval;
//    }


    @Around("@annotation(org.springframework.web.bind.annotation.PostMapping)" )
    public Object logMethodAround(ProceedingJoinPoint jp) throws Throwable {
        log.info("Entering class {} within method {} with arguments {}",
                jp.getSignature().getDeclaringTypeName(),
                jp.getSignature().getName(),
                jp.getArgs());
        long start = System.nanoTime();
        Object returnval = jp.proceed();
        long end = System.nanoTime();
        log.info("Execution time was {} in ms", TimeUnit.NANOSECONDS.toMillis(end-start));
        log.info("Exiting class {} within method {} with return value {} ",
                jp.getSignature().getDeclaringTypeName(),
                jp.getSignature().getName(),
                returnval);

        return returnval;
    }

}
