package com.springboot.crud.dao;

import com.springboot.crud.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List findAll();

    Employee findById(Integer id);

    Employee save(Employee employee);

    void deleteById(Integer id);

}
