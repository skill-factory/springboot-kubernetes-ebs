package com.springboot.crud.service;

import com.springboot.crud.dao.EmployeeDAOJPARepository;
import com.springboot.crud.entity.Employee;
import com.springboot.crud.exception.EmployeeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDAOJPARepository employeeDAO;

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public Employee findById(Integer id) {
        Optional<Employee> byId = employeeDAO.findById(id);
        return byId.orElseThrow(() -> new EmployeeNotFoundException(MessageFormat.format("No employee found with id {0}", id)));
    }

    @Override
    public void save(Employee employee) {
        employeeDAO.save(employee);
    }

    @Override
    public void deleteById(Integer id) {
        employeeDAO.deleteById(id);
    }
}