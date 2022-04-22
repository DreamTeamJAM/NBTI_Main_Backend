package com.nbti.backEnd.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nbti.backEnd.model.Company;

public interface CompanyRepository  extends JpaRepository<Company, Long>{

}
