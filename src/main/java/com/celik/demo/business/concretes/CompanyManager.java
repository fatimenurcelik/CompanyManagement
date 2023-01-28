package com.celik.demo.business.concretes;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.celik.demo.business.abstracts.CompanyService;
import com.celik.demo.business.requests.create.CreateCompanyRequest;
import com.celik.demo.business.requests.update.UpdateCompanyRequest;
import com.celik.demo.business.responses.create.CreateCompanyResponse;
import com.celik.demo.business.responses.getAll.GetAllCompanyResponse;
import com.celik.demo.business.responses.update.UpdateCompanyResponse;
import com.celik.demo.core.utilities.mapping.ModelMapperService;
import com.celik.demo.dataAccess.CompanyRepository;
import com.celik.demo.entity.Company;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CompanyManager implements CompanyService{
	
	private CompanyRepository companyRepository;
	private ModelMapperService modelMapperService;
	
	@Override
	public List<GetAllCompanyResponse> getAll() {
		 List<Company> companies = companyRepository.findAll();
	     return companies.stream().map(company -> modelMapperService.forResponse()
	                .map(company, GetAllCompanyResponse.class))
	                .collect(Collectors.toList());
	}

	@Override
	public CreateCompanyResponse add(CreateCompanyRequest createRequest) {
		Company company = modelMapperService.forRequest().map(createRequest, Company.class);
		company.setId(UUID.randomUUID().toString());
		companyRepository.save(company);
		CreateCompanyResponse companyResponse = modelMapperService.forResponse().map(company, CreateCompanyResponse.class);
		return companyResponse;
	}

	@Override
	public UpdateCompanyResponse update(UpdateCompanyRequest updateRequest) {
		Company company = modelMapperService.forRequest().map(updateRequest, Company.class);
		companyRepository.save(company);
		UpdateCompanyResponse companyResponse = modelMapperService.forResponse().map(company, UpdateCompanyResponse.class);
		return companyResponse;
	}

	@Override
	public void delete(String id) {
		companyRepository.deleteById(id);
	}
	
}
