package pl.coderslab.AOP.bookService;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect1 {

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect1.class);

    @Before("execution(* pl.coderslab.AOP.bookService.BookService.findBookById(..))")
    public void logBefore(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        logger.info("Executing: {} with id: {}", joinPoint.getSignature(), args[0]);
        logger.info("Executing: {}", joinPoint.getSignature());

    }
}
