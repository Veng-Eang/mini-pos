package com.vengeang.minipos.mapper;

import org.mapstruct.Mapper;

import com.vengeang.minipos.dto.CompanyDto;
import com.vengeang.minipos.entity.Company;

@Mapper(componentModel = "spring")
public interface CompanyMapper {

	CompanyDto toCompanyDto(Company company);
	Company toCompany(CompanyDto companyDto);
}
