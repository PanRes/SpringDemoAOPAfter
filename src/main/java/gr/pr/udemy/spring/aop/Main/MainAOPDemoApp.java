package gr.pr.udemy.spring.aop.Main;

import gr.pr.udemy.spring.aop.DemoConfig;
import gr.pr.udemy.spring.aop.beans.Account;
import gr.pr.udemy.spring.aop.dao.AccountDAO;
import gr.pr.udemy.spring.aop.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainAOPDemoApp {
	
	public static void main(String[] args) {
		
		//read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the ben from spring container
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		MembershipDAO membershipDAO = context.getBean("membershipDAO",MembershipDAO.class);
		
		Account account = new Account();
		account.setName("Panagiotis Ressos");
		account.setLevel("Debit");
		
		//all the buisiness method
		accountDAO.addAccount(account,true);
		accountDAO.doWork();
		accountDAO.setName("testName");
		accountDAO.getName();
		accountDAO.setServiceCode("testServiceCode");
		accountDAO.getServiceCode();
		
		System.out.println("call membershipDao");
		
		//call membershipDao
		membershipDAO.addMember();
		membershipDAO.goToSleep();
		
		//close the contect
		context.close();
	}
}