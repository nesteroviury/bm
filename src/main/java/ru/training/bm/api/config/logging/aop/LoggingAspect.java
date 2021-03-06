package ru.training.bm.api.config.logging.aop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    private final Logger LOGGER = LogManager.getLogger("JDBC_Logger");
    private final StringBuilder messageBuilder = new StringBuilder();
    private final String DELIMITER = ", ";
    private final String ARGNAME_ARGVALUE_DELIMITER = "=";
    private final String SEMICOLON = ": ";


    @Before("@annotation(Loggable)")
    public void beforeAdvice(JoinPoint joinPoint) {
        messageBuilder.append(joinPoint.getSignature())
                .append(SEMICOLON)
                .append("Method arguments{");

        Object[] args = joinPoint.getArgs();

        for (int i = 0; i < args.length; i++) {
            messageBuilder.append("arg" + i)
                    .append(ARGNAME_ARGVALUE_DELIMITER)
                    .append(args[i])
                    .append(DELIMITER);

        }

        messageBuilder.delete(messageBuilder.indexOf(DELIMITER), messageBuilder.length());
        messageBuilder.append("}");

        LOGGER.debug(messageBuilder.toString());
        
        messageBuilder.delete(0, messageBuilder.length());
    }

}
