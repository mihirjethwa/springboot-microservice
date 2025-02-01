package com.mihir.employee_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EmployeeDto {
	private long id;
	private String firstName;
	private String lastName;
	private String email;
	private String departmentCode;
}
