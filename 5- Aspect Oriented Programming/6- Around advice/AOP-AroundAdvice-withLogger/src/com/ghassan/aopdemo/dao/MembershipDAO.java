package com.ghassan.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

	public void addAccount() {
		System.out.println(getClass()+ ": MemebrshipDAO-->addAccount()");
	}
	
	public void goToSleep() {
		System.out.println(getClass()+ ": MemebrshipDAO-->goToSleep()");
	}
}
