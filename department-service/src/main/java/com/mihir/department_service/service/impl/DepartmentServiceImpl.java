package com.mihir.department_service.service.impl;

import org.springframework.stereotype.Service;

import com.mihir.department_service.dto.DepartmentDto;
import com.mihir.department_service.entity.Department;
import com.mihir.department_service.mapper.DepartmentMapper;
import com.mihir.department_service.repository.DepartmentRepository;
import com.mihir.department_service.service.DepartmentService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService{
	
	private DepartmentRepository departmentRepository;

	@Override
	public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
		//convert departmentDto to Department
		Department department = DepartmentMapper.INSTANCE.mapToDepartment(departmentDto);
		Department savedDepartment = departmentRepository.save(department);
		DepartmentDto resultDto = DepartmentMapper.INSTANCE.mapToDepartmentDto(savedDepartment);
		return resultDto;
	}

	@Override
	public DepartmentDto getDepartmentById(Long id) {
		Department department = departmentRepository.findById(id).orElseThrow(
				() -> null
				);
		DepartmentDto departmentDto = DepartmentMapper.INSTANCE.mapToDepartmentDto(department);
		return departmentDto;
	}

	@Override
	public DepartmentDto getDepartmentByDepartmentCode(String departmentCode) {
		Department department = departmentRepository.getDepartmentByDepartmentCode(departmentCode).orElseThrow(
				() -> null
				);
		DepartmentDto departmentDto = DepartmentMapper.INSTANCE.mapToDepartmentDto(department);
		return departmentDto;
	}
	
}
