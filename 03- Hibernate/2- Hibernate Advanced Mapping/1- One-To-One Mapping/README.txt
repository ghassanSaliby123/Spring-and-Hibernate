- This section covers the One To One mapping in a relational database 
- It covers the uni-directional and the bi-directional mapping as well as the cascading types
- The database scheme consists of two tables(Insructor and InstructorDetail)
- The sql scripts for this scheme is provided in this section as well
- This example is structured as follows:
  1- Two entity classes (Instructor and InstructorDetail)
  2- They are annotated to be mapped to the database tables
  3- In the Instructor entity we define a InstructorDetail field and we annotated with the following:
    a- @OneToOne(cascade = CascadeType.ALL) which means that the operations on Instructor will be applied on InstructorDetail as well
    b- @JoinColumn(the instructorDetail foreign key) to define the tables association
    c- In case of the uni-direcional mapping we just add these annotations to the Instructor
       In case of the bi-direcional mapping we add these annotations to both entities
 
