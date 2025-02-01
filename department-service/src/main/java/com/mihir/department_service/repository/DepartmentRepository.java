package com.mihir.department_service.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mihir.department_service.entity.Department;


public interface DepartmentRepository extends JpaRepository<Department, Long>{
	Optional<Department> getDepartmentByDepartmentCode(String departmetCode);
}
