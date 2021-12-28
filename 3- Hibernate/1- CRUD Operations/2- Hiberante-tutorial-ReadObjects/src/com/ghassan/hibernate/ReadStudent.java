package com.ghassan.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import com.ghassan.hibernate.entity.Student;


public class ReadStudent {

	public static void main(String[] args) {
		
		//Create sessionFactory 
		SessionFactory factory =  new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		//Create session
		Session session  = factory.getCurrentSession();
		
		try {
		//use the session object to retrieve java object from the BD
			
			//start a transaction
			System.out.println("1- start a transaction");
			session.beginTransaction();
			
			//retrieve the student object by Id
			System.out.println("2- retrieve the student object by Id");
			Student student = session.get(Student.class,1);
			
			//commit the transaction
			System.out.println("3- commit the transaction");
			session.getTransaction().commit();
			System.out.println("The student is : "+ student.toString());
		}
		finally {
			System.out.println("Closing the factory...");
			factory.close();
		}
	}

}
