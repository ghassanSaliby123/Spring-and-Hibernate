package com.ghassan.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ghassan.hibernate.entity.Student;

public class CreateStudents {

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
					
					//create 3 student objects
					System.out.println("1-create a student objects ");
					Student student = new Student("Ghassan","Saliby","ghassan@gmail.com");
					Student student2 = new Student("Fadi","Saliby","Fadi@gmail.com");
					Student student3 = new Student("Rita","Saliby","Rita@gmail.com");
					Student student4 = new Student("Nanar","Hawach","Nanar@gmail.com");
					
					//start a transaction
					System.out.println("2- start a transaction");
					session.beginTransaction();
					
					//save the student object
					System.out.println("3- save the student object");
					session.save(student);
					session.save(student2);
					session.save(student3);
					session.save(student4);
					
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
