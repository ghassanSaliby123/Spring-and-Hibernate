package com.ghassan.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ghassan.aopdemo.dao.AccountDAO;
import com.ghassan.aopdemo.dao.MembershipDAO;

public class MainDemo {

	//- Aspect increase the modularity by allowing the separation of cross-custting concerns
	//Does that by adding advice 
	//- Spring AOP can add advice only to methods,AspectJ can add it to methods,fields and constructs
	//- We use @Aspect to indicate the aspect class where we define the advises and @component
	//- the advice tells when we should add the code
	//- the advice needs a point cuts to define where we should add the code
	//- the syntax as follows : advice(pointCut)-->@Before("execution(,,,,)")
	//- the execution point cut pattern as follows:
	//		   execution(modifire? returnType declaringType(className)?           methodName(paramName) throws?)
	//@Before("execution(public      void     com.ghassan.aopdemo.dao.AccountDAO).addAccount()  ")
	//- We can match on methods name in any class by removing the delclaring type
	// @Before("execution(public void addAccount()")
	//- Match on method names(using wildcard)
	// @Before("execution(public void add*()")
	// - Match on return type(use wildcards)
	//@Before("execution(public * add*()")
	
	//Match Parameter Pattern wildcards:
	//() match method with no args
	//(*) match method with one arg of any type
	//(..) match method with 0 or more args of any type
	//(type1) match one arg of type1
	//- Match any method in  a package
	//execution(* com.ghassan.*.*(..))
	//match any return type in com.ghassan.CLASS.METHOD(0 or more args)
	public static void main(String[] args) {
		
		//read spring config java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the beans from the spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO",AccountDAO.class);
		MembershipDAO themebershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
		
		//call the business method
		Account account = new Account();
		theAccountDAO.addAccount(account,true);
		theAccountDAO.doWork();
		
		themebershipDAO.addAccount();
		themebershipDAO.goToSleep();
		
		//close the context
		context.close();

	}

}
