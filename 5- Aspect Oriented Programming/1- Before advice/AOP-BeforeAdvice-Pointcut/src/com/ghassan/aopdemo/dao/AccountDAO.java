package com.ghassan.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.ghassan.aopdemo.Account;

@Component
public class AccountDAO {

	public void addAccount(Account theAccount, boolean vipFlag) {
		System.out.println(getClass() + "Doing my DB work: AccountDAO-->addAccount()");
	}
	public boolean doWork() {
		System.out.println(getClass()+ ": AccountDAO-->doWork()");
		return false;
	}
}
