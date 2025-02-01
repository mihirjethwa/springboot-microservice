package com.mihir.employee_service.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.mihir.employee_service.dto.ApiResponseDto;
import com.mihir.employee_service.dto.DepartmentDto;
import com.mihir.employee_service.dto.EmployeeDto;
import com.mihir.employee_service.entity.Employee;
import com.mihir.employee_service.mapper.EmployeeMapper;
import com.mihir.employee_service.repository.EmployeeRepository;
import com.mihir.employee_service.service.ApiClient;
import com.mihir.employee_service.service.EmployeeService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{
	
	private EmployeeRepository employeeRepository;
	//depricated RestTemplate
	//private RestTemplate restTemplate;
	
	//commented because using feignclient instaed
	private WebClient webClient;
	//private ApiClient apiClient;
	
	//Logger
	private static Logger LOGGER= LoggerFactory.getLogger(EmployeeServiceImpl.class);
	
	
	@Override
	public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
		//convert EmployeeDto to Employee
		Employee employee = EmployeeMapper.INSTANCE.mapToEmployee(employeeDto);
		Employee savedEmployee = (Employee) employeeRepository.save(employee);
		EmployeeDto resultDto = EmployeeMapper.INSTANCE.mapToEmployeeDto(savedEmployee);
		return resultDto;
	}

	//@CircuitBreaker(name= "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
	@Retry(name="${spring.application.name}", fallbackMethod="getDefaultDepartment")
	@Override
	public ApiResponseDto getEmployeeById(Long id) {
		
		LOGGER.info("Inside getEmployeeById() method");
		
		Employee employee = (Employee) employeeRepository.findById(id).get();
		//depricated restTemplate
		//ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity("http://localhost:8080/department/code/"+employee.getDepartmentCode(), DepartmentDto.class)	;	
		//DepartmentDto departmentDto  = responseEntity.getBody();
		
		//commented because using feign client insted
		DepartmentDto departmentDto = webClient.get()
										.uri("http://localhost:8080/department/code/"+employee.getDepartmentCode())
										.retrieve()
										.bodyToMono(DepartmentDto.class)
										.block();
		
		//this is open feigh call 
		//DepartmentDto departmentDto = apiClient.getDepartmentByDepartmentCode(employee.getDepartmentCode());
		EmployeeDto employeeDto = EmployeeMapper.INSTANCE.mapToEmployeeDto(employee);
		ApiResponseDto apiResponse = new ApiResponseDto(employeeDto, departmentDto);
		return apiResponse;
	}

	@Override
	public EmployeeDto getEmployeeByEmail(String email) {
		Employee employee = employeeRepository.getEmployeeByEmail(email).orElseThrow(
				() -> null
				);
		EmployeeDto employeeDto = EmployeeMapper.INSTANCE.mapToEmployeeDto(employee);
		return employeeDto;
	}
	
	public ApiResponseDto getDefaultDepartment(Long employeeId, Exception exception) {
		LOGGER.info("Inside getDefaultDepartment() method");
		Employee employee = (Employee) employeeRepository.findById(employeeId).get();
		DepartmentDto departmentDto = new DepartmentDto();
		departmentDto.setDepartmentName("Fallback Department");
		departmentDto.setDepartmentDescription("This is fallback department. Service is dowwn");
		departmentDto.setDepartmentCode("D404");
		EmployeeDto employeeDto = EmployeeMapper.INSTANCE.mapToEmployeeDto(employee);
		ApiResponseDto apiResponse = new ApiResponseDto(employeeDto, departmentDto);
		return apiResponse;
	}
	
}