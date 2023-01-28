package com.celik.demo.business.abstracts;

import java.util.List;

import com.celik.demo.business.requests.create.CreateCompanyRequest;
import com.celik.demo.business.requests.update.UpdateCompanyRequest;
import com.celik.demo.business.responses.create.CreateCompanyResponse;
import com.celik.demo.business.responses.getAll.GetAllCompanyResponse;
import com.celik.demo.business.responses.update.UpdateCompanyResponse;

public interface CompanyService {
	List<GetAllCompanyResponse> getAll();
	CreateCompanyResponse add(CreateCompanyRequest createRequest);
	UpdateCompanyResponse update(UpdateCompanyRequest updateRequest);
	void delete(String id);
}
