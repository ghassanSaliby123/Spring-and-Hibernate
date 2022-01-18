By using Spring data, we get end points for CRUD operations
This app consists of:
1- The entity class: Employee
2- JpaRepository: EmployeeRepository extends JpaRepository
3- Maven pom dependency for : spring-boot-starter-data-rest

- the endpoints will be the plural of the entity name with small letter 
findAll: localhost:8080/employees
findById: localhost:8080/employees/1

- we can change the base path through the property file
spring.data.rest.base-path=/magic-api
