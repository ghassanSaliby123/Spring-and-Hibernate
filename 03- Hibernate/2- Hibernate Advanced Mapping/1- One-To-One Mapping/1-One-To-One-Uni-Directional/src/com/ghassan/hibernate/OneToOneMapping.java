package com.ghassan.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;

import com.ghassan.hibernate.entity.Instructor;
import com.ghassan.hibernate.entity.InstructorDetail;


public class OneToOneMapping {

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
			
			//create the objects
			System.out.println("1- Create Instructor and InstructorDetail");
			Instructor instructor = 
					new Instructor("Ghassan","Saliby","Ghassan@gmail.com");
			
			InstructorDetail instructorDetail = 
					new InstructorDetail("Ghassan Channel","Sports");
			
			//associate the objects
			System.out.println("2- Associate the objects");
			instructor.setInstructorDetail(instructorDetail);
			
			//start a transaction
			System.out.println("3- start a transaction");
			session.beginTransaction();
			
			//save the instructor
			//When we save the Instructor, the InstructorDetail will be saved
			//because we define the CascadeType.ALL
			System.out.println("4- Saving Instructor and InstructorDetail");
			System.out.println("Instructor: " + instructor);
			System.out.println("InstructorDetail: " + instructorDetail);
			session.save(instructor);
			
			//commit the transaction
			System.out.println("5- commit the transaction");
			session.getTransaction().commit();	
			
			System.out.println("Done!");
		}
		finally {
			System.out.println("Closing the factory...");
			factory.close();
		}
	}

}
