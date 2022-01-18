package com.ghassan.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import com.ghassan.hibernate.entity.Student;


public class CreateStudent {

	public static void main(String[] args) {
		
		//Create sessionFactory 
		SessionFactory factory =  new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		//Create session
		Session session  = factory.getCurrentSession();
		
		try {
		//use the session object to save java object in the BD
			
			//create a student object
			System.out.println("1-create a student object ");
			Student student = new Student("Ghassan","Saliby","ghassan@gmail.com");
			
			//start a transaction
			System.out.println("2- start a transaction");
			session.beginTransaction();
			
			//save the student object
			System.out.println("3- save the student object");
			session.save(student);
			
			//commit the transaction
			System.out.println("4- commit the transaction");
			session.getTransaction().commit();
		}
		finally {
			System.out.println("Closing the factory...");
			factory.close();
		}
	}

}
