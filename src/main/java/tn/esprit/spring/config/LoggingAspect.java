package tn.esprit.spring.config;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j

public class LoggingAspect {
    @Before("execution(* tn.esprit.spring.services.*.*(..))")
    public void logMethodEntry(JoinPoint joinPoint)
    { String name = joinPoint.getSignature().getName(); log.info("In method " + name + " : ");
    }
}
