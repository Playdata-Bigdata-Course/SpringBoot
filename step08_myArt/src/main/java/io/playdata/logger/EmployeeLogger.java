package io.playdata.logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class EmployeeLogger {

	private static final Logger log = LoggerFactory.getLogger(EmployeeLogger.class);
	
	@Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    public void GetMapping(){ }
	
	@Around("GetMapping()")
	public Object Around(ProceedingJoinPoint joinPoint) throws Throwable {
		log.info("====AspectJ TEST  : Around Logging Start====");
		try {
			Object result = joinPoint.proceed();
			log.info("====AspectJ TEST  : Around Logging END====");
			return result;
		} catch (Exception e) {
			log.error("====AspectJ Around Exception====");
			log.error(e.toString());
			return null;
		}
	}

}
