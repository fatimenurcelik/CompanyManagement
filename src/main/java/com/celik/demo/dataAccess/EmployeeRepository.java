package com.celik.demo.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.celik.demo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, String> {

}
