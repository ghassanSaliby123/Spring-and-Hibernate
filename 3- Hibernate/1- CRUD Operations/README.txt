- This section covers the CRUD operations on a table in a Database
- The database scheme consists of one table (Student) 
- The sql scripts for creating a user and a the scheme are provided in this section as well
- In order to set up Hibernate environment, we add the Hibrnate configuration xml file 
  which contains the database uri and the username/password 
- There is one Entity class Student annotated with the following:
  a- @Entity,@Table to map with the table
  b- @Id, @GenratedValue(strategy),@Column for the primary key field
  c- @Column for the rest of the fields
 - For each operation we should:
  a- create a sessionFactory
  b- create a session from the factory
  c- beging a transaction on the session 
  d- do a CRUD operation
  e- close the session and the factory

1-Create:
 a- we create a student object
 b- add this object to table through session.save
2- Read:
  a- get the Student by id through session.get
  b- OR we get any info from the table through queries using session.createQuery(The query).getResultList
3- Updarte: 
  a- get the student then set its field value OR
  b- create a query for update then we execute it through session.createQuery(Query).executedUpdate
4- Delete:
  a- get the student object by id then we call session.delete on that object
