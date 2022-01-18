package com.ghassan.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;

import com.ghassan.hibernate.entity.Course;
import com.ghassan.hibernate.entity.Instructor;
import com.ghassan.hibernate.entity.InstructorDetail;


public class CreateInstructorDemo {

	public static void main(String[] args) {
		
		//Create sessionFactory 
		SessionFactory factory =  new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();
		
		//Create session
		Session session  = factory.getCurrentSession();
		
		try {
			
			//create the objects
			System.out.println("1- Create Instructor and InstructorDetail");
			Instructor instructor = 
					new Instructor("Fadi","Saliby","Fadi@gmail.com");
			
			InstructorDetail instructorDetail = 
					new InstructorDetail("Fadi Channel","Games");
			
			//associate the objects 
			//Here we associate the Instructor with the InstructorDetail
			System.out.println("2- Associate the objects");
			instructorDetail.setInstructor(instructor);
			
			//start a transaction
			System.out.println("3- start a transaction");
			session.beginTransaction();
			
			//save the instructorDetail
			//When we save the InstructorDetail, the Instructor will be saved
			//because we define the CascadeType.ALL and the relationship is 
			//Bidirectional
			System.out.println("4- Saving Instructor and InstructorDetail");
			System.out.println("Instructor: " + instructor);
			System.out.println("InstructorDetail: " + instructorDetail);
			session.save(instructorDetail);
			
			//commit the transaction
			System.out.println("5- commit the transaction");
			session.getTransaction().commit();	
			
			System.out.println("Done!");
		}
		finally {
			System.out.println("Closing the factory...");
			session.close();
			factory.close();
		}
	}

}
