package gr.pr.udemy.spring.aop.aspect;

import gr.pr.udemy.spring.aop.beans.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.aspectj.lang.reflect.SourceLocation;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(1)
public class DemoLoggingAspect {

	@AfterReturning(
			pointcut = "execution(* gr.pr.udemy.spring.aop.dao.AccountDAO.findAccounts(..))",
			returning = "result")
	public void afterReturingFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {
		String method = joinPoint.getSignature().toShortString();
		
		System.out.println("\n====> Executing @AfterReturning on method: " + method);
		
		System.out.println("\n====> result is: " + result);
		
		if (!result.isEmpty()) {
			result.get(0).setName("PR is Awesome");
		}
	}

	@Before("AopPointcutExpressions.forDaoPackgeNotGettersSetters()")
	public void beforeAddAccountAdvice(JoinPoint joinPoint) {
		System.out.println("\n=====>>> Executing @Before advice on AddAccount()");
		
		//display the method signature
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		
		System.out.println("Method: " + methodSignature);
		System.out.println("Kind: " + joinPoint.getKind());
		System.out.println("Static Part: " + joinPoint.getStaticPart());
		System.out.println("Class: " + joinPoint.getTarget().getClass());
		System.out.println("Signature: " + joinPoint.getSignature().getName());
		System.out.println("Modifiers: " + joinPoint.getSignature().getModifiers());
		System.out.println("ReturnType: " + ((MethodSignature) joinPoint.getSignature()).getReturnType());
		System.out.println("Declaring Type Name: " + joinPoint.getSignature().getDeclaringTypeName());
		
		//display method arguments
		
		//get args
		Object[] args = joinPoint.getArgs();
		
		//loop through args
		for (Object arg : args) {
			System.out.println(arg);
			
			if (arg instanceof Account) {
				Account account = (Account) arg;
				
				System.out.println("account name: " + account.getName());
				System.out.println("account Level: " + account.getLevel());
			}
		}
	}
}
