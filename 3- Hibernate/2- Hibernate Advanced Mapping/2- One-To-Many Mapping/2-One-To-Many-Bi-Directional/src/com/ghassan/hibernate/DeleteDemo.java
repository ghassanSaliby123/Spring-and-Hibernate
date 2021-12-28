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
			
			//get the InstructorDetail by Id
			int theId = 3;
			System.out.println("2- retrieve Instructor by Id");
			InstructorDetail instructorDetail = session.get(InstructorDetail.class, theId);
			System.out.println("Instructor: " + instructorDetail);
			//This will also delete the Instructor CascadeType.ALL
			//But we should first break the association 
			instructorDetail.getInstructor().setInstructorDetail(null);
			if(instructorDetail != null) {
			session.delete(instructorDetail);
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
