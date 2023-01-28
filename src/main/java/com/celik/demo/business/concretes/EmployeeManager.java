package com.celik.demo.business.concretes;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.celik.demo.business.abstracts.EmployeeService;
import com.celik.demo.business.requests.create.CreateEmployeeRequest;
import com.celik.demo.business.requests.update.UpdateEmployeeRequest;
import com.celik.demo.business.responses.create.CreateEmployeeResponse;
import com.celik.demo.business.responses.getAll.GetAllEmployeeResponse;
import com.celik.demo.business.responses.update.UpdateEmployeeResponse;
import com.celik.demo.core.utilities.mapping.ModelMapperService;
import com.celik.demo.dataAccess.EmployeeRepository;
import com.celik.demo.entity.Employee;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeManager implements EmployeeService{
	
	private EmployeeRepository employeeRepository;
	private ModelMapperService mapperService;
	
	@Override
	public List<GetAllEmployeeResponse> getAll() {
		List<Employee> employees= employeeRepository.findAll();
	    return employees.stream().map(employee -> mapperService.forResponse()
	                .map(employee, GetAllEmployeeResponse.class))
	                .collect(Collectors.toList());
	}

	@Override
	public CreateEmployeeResponse add(CreateEmployeeRequest createRequest) {
		Employee employee = mapperService.forRequest().map(createRequest, Employee.class);
		employee.setId(UUID.randomUUID().toString());
		employeeRepository.save(employee);
		CreateEmployeeResponse employeeResponse = mapperService.forResponse().map(employee, CreateEmployeeResponse.class);
		return employeeResponse;
	}

	@Override
	public UpdateEmployeeResponse update(UpdateEmployeeRequest updateRequest) {
		Employee employee= mapperService.forRequest().map(updateRequest, Employee.class);
		employeeRepository.save(employee);
		UpdateEmployeeResponse companyResponse = mapperService.forResponse().map(employee, UpdateEmployeeResponse.class);
		return companyResponse;
	}

	@Override
	public void delete(String id) {
		employeeRepository.deleteById(id);
	}

}
