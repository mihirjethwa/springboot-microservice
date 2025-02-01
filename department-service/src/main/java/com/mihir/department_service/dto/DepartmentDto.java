package com.mihir.department_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDto {
	private long id;
	private String departmentName;
	private String departmentDescription;
	private String departmentCode;
}
