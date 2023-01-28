package com.celik.demo.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.celik.demo.entity.Company;

public interface CompanyRepository extends JpaRepository<Company, String>{

}
