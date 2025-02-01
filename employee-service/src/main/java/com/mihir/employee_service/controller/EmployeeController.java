package com.mihir.employee_service.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mihir.employee_service.dto.ApiResponseDto;
import com.mihir.employee_service.dto.EmployeeDto;
import com.mihir.employee_service.service.EmployeeService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/employee")
@AllArgsConstructor
public class EmployeeController {
	
	private EmployeeService employeeService;
	
	@PostMapping("/create")
	public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) {
		System.out.println(employeeDto.toString());
		EmployeeDto savedEmployee = employeeService.saveEmployee(employeeDto);
		return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ApiResponseDto> getEmployeeById(@PathVariable Long id){
		ApiResponseDto apiResponseDto = employeeService.getEmployeeById(id);
		return new ResponseEntity<>(apiResponseDto, HttpStatus.OK);
	}
	@GetMapping("/email/{email}")
	public ResponseEntity<EmployeeDto> getEmployeeByEmail(@PathVariable String email){
		EmployeeDto employeeDto = employeeService.getEmployeeByEmail(email);
		return new ResponseEntity<>(employeeDto, HttpStatus.OK);
	}
}
