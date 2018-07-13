package gr.pr.udemy.spring.aop.Main;

import gr.pr.udemy.spring.aop.DemoConfig;
import gr.pr.udemy.spring.aop.beans.Account;
import gr.pr.udemy.spring.aop.dao.AccountDAO;
import gr.pr.udemy.spring.aop.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterReturningDemoApp {
	
	public static void main(String[] args) {
		
		//read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the ben from spring container
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		List<Account> accounts = accountDAO.findAccounts();
		
		System.out.println("\n\nMain Program: AfterReturningDemoApp");
		
		System.out.println(accounts);
		
		System.out.println("\n");
		
		//close the contect
		context.close();
	}
}