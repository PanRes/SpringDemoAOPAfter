package gr.pr.udemy.spring.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(4)
public class CloudLogAsyncAspect {
	
	@Before("AopPointcutExpressions.forDaoPackgeNotGettersSetters()")
	public void logToCloudeAsync() {
		System.out.println("\n=====>>> Logging to cloud Async");
	}
	
}
