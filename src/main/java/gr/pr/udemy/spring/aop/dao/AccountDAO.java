package gr.pr.udemy.spring.aop.dao;

import gr.pr.udemy.spring.aop.beans.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDAO {
	
	private String name;
	private String serviceCode;
	
	public List<Account> findAccounts() {
		List<Account> accounts = new ArrayList<Account>();
		
		accounts.add(new Account("PR", "Red"));
		accounts.add(new Account("McCoy", "Platinum"));
		accounts.add(new Account("Angel", "Black"));
		
		System.out.println("\nInside findAccounts()\n");
		
		return accounts;
	}
	
	public void addAccount(Account account, boolean vipFlag) {
		System.out.println(getClass() + " : DOING MY DB STUFF ABOUT: " + account.getName());
	}
	
	public boolean doWork() {
		System.out.println(getClass() + ": Doing Stuff");
		
		return false;
	}
	
	public String getName() {
		System.out.println(getClass() + " : getName() called");
		return name;
	}
	
	public void setName(String name) {
		System.out.println(getClass() + " : setName() called");
		this.name = name;
	}
	
	public String getServiceCode() {
		System.out.println(getClass() + " : getServiceCode() called");
		return serviceCode;
	}
	
	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() + " : serviceCode() called");
		this.serviceCode = serviceCode;
	}
}
