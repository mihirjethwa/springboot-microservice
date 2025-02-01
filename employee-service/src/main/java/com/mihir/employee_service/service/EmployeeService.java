package com.mihir.employee_service.service;

import com.mihir.employee_service.dto.ApiResponseDto;
import com.mihir.employee_service.dto.EmployeeDto;

public interface EmployeeService {
	EmployeeDto saveEmployee(EmployeeDto employeeDto);
	ApiResponseDto getEmployeeById(Long id);
	EmployeeDto getEmployeeByEmail(String email);
}