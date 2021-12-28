package com.ghassan.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

import org.hibernate.Session;
import com.ghassan.hibernate.entity.Student;


public class QueryStudents {

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
			
			//Query all the student objects 
			//All the names in the query are objects names not table names
			System.out.println("2- Query all the student objects");
			List<Student> students = session
					.createQuery("from Student")
					.getResultList();
			
			//print all students
			displayStudent(students);
			
			//Query students = lastName= saliby
			List<Student> studentList2 = session
					.createQuery("from Student s where s.lastName = 'Saliby'")
					.getResultList();
			//print all students
			displayStudent(studentList2);
			
			//Query students = lastName= saliby or firstName = Nanar
			List<Student> studentList3 = session
					.createQuery("from Student s where s.lastName = 'Saliby'"
							+ " or s.firstName = 'Nanar'")
					.getResultList();
			//print all students
			displayStudent(studentList3);
			
			//Query students where email LIKE ghassan%
			List<Student> studentList4 = session
					.createQuery("from Student s where s.email LIKE 'ghassan%'")
					.getResultList();
			//print all students
			displayStudent(studentList4);
			//commit the transaction
			System.out.println("3- commit the transaction");
			session.getTransaction().commit();
		
		}
		finally {
			System.out.println("Closing the factory...");
			factory.close();
		}
	}

	private static void displayStudent(List<Student> students) {
		for(Student theStudent: students) {
			System.out.println(theStudent);
		}
	}

}
