package com.example.cruddemo.dao;

import com.example.cruddemo.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // that's it .... no need to write any code.
}
