package com.springboot.crud.rest;

import com.springboot.crud.constants.APIMappings;
import com.springboot.crud.entity.Employee;
import com.springboot.crud.service.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(APIMappings.ROOT)
@Api(description = "Employee Rest controller")
public class EmployeeRestController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(APIMappings.GET_ALL_EMPLOYEES)
    @ApiOperation(value = "Get all employees")
    private List<Employee> getAllEmployees() {
        return employeeService.findAll();
    }

    @GetMapping(APIMappings.GET_EMPLOYEE_BY_ID)
    @ApiOperation(value = "Get employee by id")
    private Employee getEmployeeById(@PathVariable("id") @ApiParam(value = "Id of employee") Integer id) {
        Employee byId = employeeService.findById(id);
        if (Objects.isNull(byId)) {
            throw new RuntimeException("No employee found with id - " + id);
        }
        return byId;
    }

    @PostMapping(APIMappings.ADD_EMPLOYEE)
    @ApiOperation(value = "add an employee")
    private Employee addEmployee(@RequestBody @ApiParam(value = "employee") Employee employee) {
        employeeService.save(employee);
        return employee;
    }

    @PutMapping(APIMappings.UPDATE_EMPLOYEE)
    @ApiOperation(value = "Update an employee")
    private Employee updateEmployee(@RequestBody @ApiParam(value = "employee") Employee employee) {
        employeeService.save(employee);
        return employee;
    }

    @DeleteMapping(APIMappings.DELETE_EMPLOYEE)
    @ApiOperation(value = "Delete an employee by id")
    private String deleteEmployee(@PathVariable("id") @ApiParam(value = "Id of employee") Integer id) {
        Employee byId = employeeService.findById(id);
        if (Objects.isNull(byId)) {
            throw new RuntimeException("No employee found with id - " + id);
        }
        employeeService.deleteById(id);
        return "Deleted employee with id - " + id;
    }

}