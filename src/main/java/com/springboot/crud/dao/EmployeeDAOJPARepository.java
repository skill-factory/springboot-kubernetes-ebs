package com.springboot.crud.dao;

import com.springboot.crud.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDAOJPARepository extends JpaRepository<Employee,Integer> {

}