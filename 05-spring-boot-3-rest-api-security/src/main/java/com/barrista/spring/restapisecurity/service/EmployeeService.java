package com.barrista.spring.restapisecurity.service;


import com.barrista.spring.restapisecurity.entity.Employee;
import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int theId);

    Employee save(Employee theEmployee);

    void deleteById(int theId);

}
