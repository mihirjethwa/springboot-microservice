package com.mihir.employee_service.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mihir.employee_service.dto.DepartmentDto;

@FeignClient(name = "DEPARTMENT-SERVICE")
public interface ApiClient {
	@GetMapping("/department/code/{code}")
	DepartmentDto getDepartmentByDepartmentCode(@PathVariable String code);
}
