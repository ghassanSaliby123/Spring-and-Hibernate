package com.ghassan.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;

import com.ghassan.hibernate.entity.Course;
import com.ghassan.hibernate.entity.Instructor;
import com.ghassan.hibernate.entity.InstructorDetail;


public class GetInstructorCoursesDemo {

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
		
			//start a transaction
			System.out.println("1- start a transaction");
			session.beginTransaction();
			
			//get the instructor from db
			int instructorId = 1;
			Instructor instructor = session.get(Instructor.class, instructorId);
			
			System.out.println(instructor);
			//get the courses for the instructor
			System.out.println(instructor.getCourses());
			
			//commit the transaction
			System.out.println(" commit the transaction");
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
