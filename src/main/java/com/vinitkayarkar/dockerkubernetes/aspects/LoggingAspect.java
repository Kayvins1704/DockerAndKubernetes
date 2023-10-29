package com.vinitkayarkar.dockerkubernetes.aspects;

import com.vinitkayarkar.dockerkubernetes.entities.User;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Around("execution(* com.vinitkayarkar.dockerkubernetes..*(..)) && @annotation(Loggable)")
    public Object logSensitiveData(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        // Modify or mask args as needed.
        // For example, let's assume arg[0] is a User object and you want to mask its password:
        ((User) args[0]).setPassword("MASKED");


        logger.info("Method called: {}", joinPoint.getSignature().getName());
        Object result = joinPoint.proceed(args);  // Continue with the actual method execution
        // Similarly, modify or mask result if necessary.

        return result;
    }
}
