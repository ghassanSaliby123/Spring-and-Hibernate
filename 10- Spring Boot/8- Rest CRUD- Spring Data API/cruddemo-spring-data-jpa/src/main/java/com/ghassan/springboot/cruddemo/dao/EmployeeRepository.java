package com.ghassan.springboot.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ghassan.springboot.cruddemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
