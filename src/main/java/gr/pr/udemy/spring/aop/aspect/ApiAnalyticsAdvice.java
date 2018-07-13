package gr.pr.udemy.spring.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(4)
public class ApiAnalyticsAdvice {
	
	@Before("AopPointcutExpressions.forDaoPackgeNotGettersSetters()")
	public void performApiAnalytics() {
		System.out.println("\n=====>>> Performing Api Analytics");
	}
	
}
