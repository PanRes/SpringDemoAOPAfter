package gr.pr.udemy.spring.aop.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

	public boolean addMember() {
		System.out.println(getClass() + " : DOING DB STUFF");
		
		return true;
	}
	
	public boolean goToSleep() {
		System.out.println(getClass() + " : I'm going to die now");
		
		return true;
	}

}
