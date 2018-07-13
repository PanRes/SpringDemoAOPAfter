package gr.pr.udemy.spring.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopPointcutExpressions {
	
	@Pointcut("execution(* gr.pr.udemy.spring.aop.dao.*.*(..))")
	public void forDaoPackage() {}
	
	@Pointcut("execution(* gr.pr.udemy.spring.aop.dao.*.get*(..))")
	public void getters() {}
	
	@Pointcut("execution(* gr.pr.udemy.spring.aop.dao.*.set*(..))")
	public void setters() {}
	
	@Pointcut("forDaoPackage() && !(getters() || setters())")
	public void forDaoPackgeNotGettersSetters() {}
	
}
