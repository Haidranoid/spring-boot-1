package com.example.cruddemo.dao;

import com.example.cruddemo.entities.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

    // define field for entity-manager
    EntityManager entityManager;

    // set up constructor injection
    @Autowired
    public EmployeeDAOJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        // create a query
        TypedQuery<Employee> query = entityManager.createQuery("SELECT e FROM Employee e", Employee.class);
        // execute query and get result list
        List<Employee> employees = query.getResultList();
        // return the results
        return employees;
    }

    @Override
    public Employee findByID(int id) {
        // ge the employee
        Employee employee = entityManager.find(Employee.class, id);

        // return employee
        return employee;
    }

    @Override
    public Employee save(Employee employee) {
        // if id == 0 the insert/save, else update
        Employee dbEmployee = entityManager.merge(employee);

        // return the dbEmployee
        return dbEmployee;
    }

    @Override
    public void deleteById(int id) {
        // find employee by id
        Employee employee = entityManager.find(Employee.class, id);

        //remove employee
        entityManager.remove(employee);
    }
}
