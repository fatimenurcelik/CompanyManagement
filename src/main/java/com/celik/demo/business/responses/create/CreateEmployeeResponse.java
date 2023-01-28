package com.celik.demo.business.responses.create;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor 
public class CreateEmployeeResponse {
	private String id;
	private String name;
	private String surname;
	private int age;
	private String companyId;
}
