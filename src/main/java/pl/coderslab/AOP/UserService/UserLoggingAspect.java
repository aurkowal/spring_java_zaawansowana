package pl.coderslab.AOP.UserService;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class UserLoggingAspect {

    @Before("execution(* pl.coderslab.AOP.UserService.UserService.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println(
                "Calling method: " + joinPoint.getSignature().getName() +
                        ", args: " + Arrays.toString(joinPoint.getArgs())
        );
    }

    @AfterReturning("execution(* pl.coderslab.AOP.UserService.UserService.*(..))")
    public void logAfter(JoinPoint joinPoint) {
        System.out.println(
                "Finished method: " + joinPoint.getSignature().getName()
        );
    }

    @AfterThrowing(
            pointcut = "execution(* pl.coderslab.AOP.UserService.UserService.*(..))",
            throwing = "ex"
    )
    public void logException(JoinPoint joinPoint, Throwable ex) {
        System.out.println(
                "Exception in method: " + joinPoint.getSignature().getName() +
                        ", message: " + ex.getMessage()
        );
    }
}