package com.mihir.employee_service.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mihir.employee_service.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	Optional<Employee> getEmployeeByEmail(String email);
}
