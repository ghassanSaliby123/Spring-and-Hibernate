package com.ghassan.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ghassan.aopdemo.Account;

@Component
public class AccountDAO {

	private String name;
	private String serviceCode;
	
	public void addAccount(Account theAccount, boolean vipFlag) {
		System.out.println(getClass() + "Doing my DB work: AccountDAO-->addAccount()");
	}
	
	public boolean doWork() {
		System.out.println(getClass()+ ": AccountDAO-->doWork()");
		return false;
	}
	
	public List<Account> findAccounts(boolean tripWire){
		
		//simulate an exception
		if(tripWire) {
			throw new RuntimeException("Simultaed exception");
		}
		List<Account> myAccounts = new ArrayList<Account>();
		//Create sample accounts
		Account temp1 = new Account("John","Silver");
		Account temp2 = new Account("Madu","Platinum");
		Account temp3 = new Account("Luca","Gold");
		
		myAccounts.add(temp1);
		myAccounts.add(temp2);
		myAccounts.add(temp3);
		
		return myAccounts;
	}
	
	public String getName() {
		System.out.println(getClass()+ ": AccountDAO-->getName()");
		return name;
	}
	
	public void setName(String name) {
		System.out.println(getClass()+ ": AccountDAO-->setName()");
		this.name = name;
	}
	
	public String getServiceCode() {
		System.out.println(getClass()+ ": AccountDAO-->getServiceCode()");
		return serviceCode;
	}
	
	public void setServiceCode(String serviceCode) {
		System.out.println(getClass()+ ": AccountDAO-->setServiceCode()");
		this.serviceCode = serviceCode;
	}
}
