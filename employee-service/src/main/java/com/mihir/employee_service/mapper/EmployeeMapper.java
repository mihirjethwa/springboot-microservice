package com.mihir.employee_service.mapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.mihir.employee_service.dto.EmployeeDto;
import com.mihir.employee_service.entity.Employee;

@Mapper
public interface EmployeeMapper {
	
	EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);
	
	EmployeeDto mapToEmployeeDto(Employee department);
	
	Employee mapToEmployee(EmployeeDto departmentDto);
}
