This section covers the Many To Many mapping in a relational database 
- The database scheme consists of 5 tables(Insructor,InstructorDetail, Course, Review, Student)
- The relationship between Course and Student is ManyToMany
- We apply this relationship thorugh a join table(course_student) which contains foreign keys for both Course and Student:
  a- on the Course class we define a field for Student and we annotated with the following:
      @ManyToMany(fetch = FetchType.LAZY,
          cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
      @JoinTable(
          name = "course_student",
          joinColumns = @JoinColumn(name = "course_id"),
          inverseJoinColumns = @JoinColumn(name = "student_id"))
 b- on the Student class we define a field for Course and we annotated with the following:
     @ManyToMany(fetch = FetchType.LAZY,
          cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
      @JoinTable(
          name = "course_student",
          joinColumns = @JoinColumn(name = "student_id"),
          inverseJoinColumns = @JoinColumn(name = "course_id"))
