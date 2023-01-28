package com.celik.demo.business.responses.update;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor 
public class UpdateEmployeeResponse {
	private String id;
	private String name;
	private String surname;
	private int age;
	private String companyId;
}
