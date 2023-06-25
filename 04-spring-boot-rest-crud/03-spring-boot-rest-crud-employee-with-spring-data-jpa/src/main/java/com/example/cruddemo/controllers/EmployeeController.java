package com.example.cruddemo.controllers;

import com.example.cruddemo.entities.Employee;
import com.example.cruddemo.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    private EmployeeService employeeService;

    // inject employeeDAO (use constructor injection)
    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // expose GET "/employees" and return a list of employees
    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return this.employeeService.findAll();
    }

    // expose GET "/employees/{id}" and returns the specific employee
    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id) {
        Employee employee = employeeService.findById(id);

        if (employee == null) {
            throw new RuntimeException("Employee id not found - " + id);
        }

        return employee;
    }

    // expose POST "/employees" and return the employee created
    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee) {
        // just in case they pass an id in JSON ... set id to 0
        // this is to force a save of new item ... instead of update
        employee.setId(0);

        // create employee based on request

        return this.employeeService.save(employee);
    }

    // expose PUT "/employees/{id}" and return the employee updated
    @PutMapping("/employees/{id}")
    public Employee updateEmployee(@PathVariable int id, @RequestBody Employee employee) {
        Employee dbEmployee = this.employeeService.findById(id);

        if (dbEmployee == null) {
            throw new RuntimeException("Employee id not found - " + id);
        }

        // employee.setId(id);
        employee.setId(dbEmployee.getId());

        System.out.println(dbEmployee);
        System.out.println(employee);
        // update employee based on request
        return this.employeeService.save(employee);
    }

    // expose DELETE "/employees/{id}" and delete a specific employee
    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable int id) {
        Employee dbEmployee = this.employeeService.findById(id);

        if (dbEmployee == null) {
            throw new RuntimeException("Employee id not found - " + id);
        }

        this.employeeService.deleteById(dbEmployee.getId());
    }
}
