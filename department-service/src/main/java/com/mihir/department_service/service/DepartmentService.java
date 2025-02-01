package com.mihir.department_service.service;

import com.mihir.department_service.dto.DepartmentDto;

public interface DepartmentService {
	DepartmentDto saveDepartment(DepartmentDto departmentDto);
	DepartmentDto getDepartmentById(Long id);
	DepartmentDto getDepartmentByDepartmentCode(String departmentCode);
}	
