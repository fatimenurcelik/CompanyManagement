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

import com.celik.demo.business.abstracts.CompanyService;
import com.celik.demo.business.requests.create.CreateCompanyRequest;
import com.celik.demo.business.requests.update.UpdateCompanyRequest;
import com.celik.demo.business.responses.create.CreateCompanyResponse;
import com.celik.demo.business.responses.getAll.GetAllCompanyResponse;
import com.celik.demo.business.responses.update.UpdateCompanyResponse;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/companies")
public class CompanyController {
	private CompanyService companyService;
	
	@GetMapping()
	public List<GetAllCompanyResponse> getAll(){
		return companyService.getAll();
	}
	
	@PostMapping()
	public CreateCompanyResponse add(@RequestBody CreateCompanyRequest createRequest) {
		return companyService.add(createRequest);
	}
	
	@PutMapping()
	public UpdateCompanyResponse update(@RequestBody UpdateCompanyRequest updateRequest) {
		return companyService.update(updateRequest);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable String id) {
		companyService.delete(id);
	}
}
