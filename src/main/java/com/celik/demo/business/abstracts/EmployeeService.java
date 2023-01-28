package com.celik.demo.business.abstracts;

import java.util.List;

import com.celik.demo.business.requests.create.CreateEmployeeRequest;
import com.celik.demo.business.requests.update.UpdateEmployeeRequest;
import com.celik.demo.business.responses.create.CreateEmployeeResponse;
import com.celik.demo.business.responses.getAll.GetAllEmployeeResponse;
import com.celik.demo.business.responses.update.UpdateEmployeeResponse;

public interface EmployeeService {
	List<GetAllEmployeeResponse> getAll();
	CreateEmployeeResponse add(CreateEmployeeRequest createRequest);
	UpdateEmployeeResponse update(UpdateEmployeeRequest updateRequest);
	void delete(String id);
}