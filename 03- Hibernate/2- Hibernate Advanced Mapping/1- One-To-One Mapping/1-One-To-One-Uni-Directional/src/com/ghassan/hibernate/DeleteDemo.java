package com.ghassan.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;

import com.ghassan.hibernate.entity.Instructor;
import com.ghassan.hibernate.entity.InstructorDetail;


public class DeleteDemo {

	public static void main(String[] args) {
		
		//Create sessionFactory 
		SessionFactory factory =  new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		
		//Create session
		Session session  = factory.getCurrentSession();
		
		try {
			
			//start a transaction
			System.out.println("1- start a transaction");
			session.beginTransaction();
			
			//get the Instructor by Id
			int theId = 1;
			System.out.println("2- retrieve Instructor by Id");
			Instructor instructor = session.get(Instructor.class, theId);
			System.out.println("Instructor: " + instructor);
			//This will also delete the InstructorDetail CascadeType.ALL
			if(instructor != null) {
			session.delete(instructor);
			}
			
			//commit the transaction
			System.out.println("3- commit the transaction");
			session.getTransaction().commit();	
			
			System.out.println("Done!");
		}
		finally {
			System.out.println("Closing the factory...");
			factory.close();
		}
	}

}
