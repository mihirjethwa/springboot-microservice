package com.mihir.department_service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.mihir.department_service.dto.DepartmentDto;
import com.mihir.department_service.entity.Department;

@Mapper
public interface DepartmentMapper {
	
	DepartmentMapper INSTANCE = Mappers.getMapper(DepartmentMapper.class);
		
	DepartmentDto mapToDepartmentDto(Department department);
	Department mapToDepartment(DepartmentDto departmentDto);
}
