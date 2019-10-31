package com.springboot.crud.dao;

import com.springboot.crud.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.Objects;

@Repository("JPAImpl")
public class EmployeeDAOJPAImpl implements EmployeeDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Employee> findAll() {
        Query from_employee = entityManager.createQuery("from Employee");
        return from_employee.getResultList();
    }

    @Override
    public Employee findById(Integer id) {
        Employee employee = entityManager.find(Employee.class, id);
        if (Objects.isNull(employee)) {
            throw new RuntimeException("No employee found with id - "+id);
        }
        return employee;
    }

    @Override
    public Employee save(Employee employee) {
        Employee employeeFromDB = entityManager.merge(employee);
        employee.setId(employeeFromDB.getId());
        return employee;
    }

    @Override
    public void deleteById(Integer id) {
        Query query = entityManager.createQuery("delete from Employee where id=:id");
        query.setParameter("id",id);
        query.executeUpdate();
    }
}
