package com.ghassan.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;

import com.ghassan.hibernate.entity.Course;
import com.ghassan.hibernate.entity.Instructor;
import com.ghassan.hibernate.entity.InstructorDetail;
import com.ghassan.hibernate.entity.Review;
import com.ghassan.hibernate.entity.Student;


public class CreateCourseAndStudentsDemo {

	public static void main(String[] args) {
		
		//Create sessionFactory 
		SessionFactory factory =  new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		//Create session
		Session session  = factory.getCurrentSession();
		
		try {
		
			//start a transaction
			System.out.println("1- start a transaction");
			session.beginTransaction();
			
			//create some courses
			Course course1 = new Course("Maths");
			
			//save the courses
			session.save(course1);
			
			//create student
			Student student1 = new Student("John", "Doe","john@gmail.com");
			Student student2 = new Student("Mary", "Publuc","mary@gmail.com");
			
			//add student to course
			course1.addStudent(student1);
			course1.addStudent(student2);
			
			//save students
			session.save(student1);
			session.save(student2);
			
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
