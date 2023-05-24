package com.barrista.spring.restapisecurity.dao;


import com.barrista.spring.restapisecurity.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
