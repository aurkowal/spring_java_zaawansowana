package pl.coderslab.AOP.zadanie1;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LoggingAspect {

    @Around("@annotation(pl.coderslab.AOP.Logged)")
    public Object logMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Method called: " + joinPoint.getSignature().toShortString() +
                " with arguments: " + Arrays.toString(joinPoint.getArgs()));
        Object result = joinPoint.proceed();
        System.out.println("Method returned: " + result);
        return result;
    }
}
