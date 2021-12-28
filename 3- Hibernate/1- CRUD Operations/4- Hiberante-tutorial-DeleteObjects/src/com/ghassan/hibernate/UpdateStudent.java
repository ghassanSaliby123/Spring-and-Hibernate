package com.ghassan.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import com.ghassan.hibernate.entity.Student;


public class UpdateStudent {

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
			
			//Update a student object by Id
			System.out.println("2- Update a student object by Id");
			int studentId = 1;
			Student student = session.get(Student.class,studentId);
			student.setEmail("foo@gmail.com");
		
			//commit the transaction
			System.out.println("3- commit the transaction");
			session.getTransaction().commit();
			System.out.println("The student is : "+ student.toString());
			
			//New session
			System.out.println("New session");
			session = factory.getCurrentSession();
			System.out.println("start a transaction");
			session.beginTransaction();
			
			//Update with a query using executeUpdate
			System.out.println("Update with a query using executeUpdate");
			session.createQuery("update Student set email ='foo@gmail.com'")
			.executeUpdate();
			System.out.println("Done!");
			//commit the transaction
			session.getTransaction().commit();
		}
		finally {
			System.out.println("Closing the factory...");
			factory.close();
		}
	}

}
