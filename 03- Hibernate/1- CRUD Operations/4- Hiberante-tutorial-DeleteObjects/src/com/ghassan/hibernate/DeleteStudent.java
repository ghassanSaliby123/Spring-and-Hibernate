package com.ghassan.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import com.ghassan.hibernate.entity.Student;


public class DeleteStudent {

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
			
			//Delete the student object by Id
			System.out.println("2- Delete the student object by Id");
			int studentId = 1;
			Student student = session.get(Student.class, studentId);
			if(student !=null) {
			session.delete(student);
			System.out.println("Deleting is done!");
			}
			
			//commit the transaction
			System.out.println("3- commit the transaction");
			session.getTransaction().commit();
			
			//New session
			session= factory.getCurrentSession();
			session.beginTransaction();
			
			//Delete the student object by a clause with executeUpdate
			System.out.println("Delete the student object by a clause");
			
			session.createQuery("Delete from Student where id = 2").executeUpdate();
			System.out.println("Deleting is done");
			
			//commit the transaction
			System.out.println(" commit the transaction");
			session.getTransaction().commit();
		}
		finally {
			System.out.println("Closing the factory...");
			factory.close();
		}
	}

}
