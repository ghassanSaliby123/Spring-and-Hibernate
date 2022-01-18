package com.ghassan.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbcConnection {

	//In order to set up Hibernate environment 
	//1- add Hibrnate configuration file
	//2- Annotate Java class
	//Entity class is a java class that is mapped to a database table
	//ORM Object to Relashioanl Mapping
	//Two options for mapping:
	// a- XML configuration: We don't cover it here
	// b- Java annotations:
	//		I-Map class to database table:
	//			@Entity
	//			@Table(name ="table name")
	//			public class Student{}
	//		II- Map fields to database columns
	//			@Id ..primary key
	//			@Column(name = "column name")
	//			private int id;
	//EX: 
	//3- Develop java code to perform database operations
	//	Two key players here:
	//	a- SessionFactory : Reads hibernate config file-create session objects
	//						Created once 
	//		SeesionFactory factory = new Configuration()
	//									.configure("Config file")
	//									.AddAnnotationClass(Entity class)
	//									.buildSessionFacoty()
	//	b- Session : Wraps a JDBC connection-It is main object used to save/retrieve
	//				objects to DB - it is a short lived object
	//				Retrieved from SessionFactory;
	//		Session session = factory.getCurrentSession();
	//		try{do the business....
	//				For saving :
	//				Create entity object
	//				start transaction ..session.beginTransaction()
	//				save entity ....session.save(entity)
	//				commit transaction .... session.getTransation().commit()
	//	}
	//		finally{factory.close()}
	public static void main(String[] args) {
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false"
				+ "&serverTimezone=UTC";
		String user = "hbstudent";
		String pass = "hbstudent";
		
		try {
			System.out.println("Connecting to database: "+ jdbcUrl);
			Connection connection = DriverManager.getConnection(jdbcUrl,user,pass);
			System.out.println("Connection successful...");
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
