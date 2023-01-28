package com.celik.demo.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.celik.demo.business.abstracts.EmployeeService;
import com.celik.demo.business.requests.create.CreateEmployeeRequest;
import com.celik.demo.business.requests.update.UpdateEmployeeRequest;
import com.celik.demo.business.responses.create.CreateEmployeeResponse;
import com.celik.demo.business.responses.getAll.GetAllEmployeeResponse;
import com.celik.demo.business.responses.update.UpdateEmployeeResponse;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	private EmployeeService employeeService;
	
	@GetMapping()
	public List<GetAllEmployeeResponse> getAll(){
		return employeeService.getAll();
	}
	
	@PostMapping()
	public CreateEmployeeResponse add(@RequestBody CreateEmployeeRequest createRequest) {
		return employeeService.add(createRequest);
	}
	
	@PutMapping()
	public UpdateEmployeeResponse update(@RequestBody UpdateEmployeeRequest updateRequest) {
		return employeeService.update(updateRequest);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable String id) {
		employeeService.delete(id);
	}
}
