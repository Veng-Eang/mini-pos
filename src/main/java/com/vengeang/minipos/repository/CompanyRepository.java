package com.vengeang.minipos.repository;


import org.springframework.stereotype.Repository;

import com.vengeang.minipos.entity.Company;

@Repository
public interface CompanyRepository extends GenericRepository<Company, Long> {
	
}
