package com.mihir.department_service.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mihir.department_service.dto.DepartmentDto;
import com.mihir.department_service.service.DepartmentService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/department")
@AllArgsConstructor
public class DepartmentController {
	
	private DepartmentService departmentService;
	
	@PostMapping("/create")
	public ResponseEntity<DepartmentDto> createDepartment(@RequestBody DepartmentDto departmentDto) {
		DepartmentDto savedDepartment = departmentService.saveDepartment(departmentDto);
		return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DepartmentDto> getDepartmentById(@PathVariable Long id){
		DepartmentDto departmentDto = departmentService.getDepartmentById(id);
		return new ResponseEntity<>(departmentDto, HttpStatus.OK);
	}
	@GetMapping("/code/{code}")
	public ResponseEntity<DepartmentDto> getDepartmentByDepartmentCode(@PathVariable String code){
		DepartmentDto departmentDto = departmentService.getDepartmentByDepartmentCode(code);
		return new ResponseEntity<>(departmentDto, HttpStatus.OK);
	}
}
