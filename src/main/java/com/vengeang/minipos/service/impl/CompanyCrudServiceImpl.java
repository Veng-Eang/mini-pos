package com.vengeang.minipos.service.impl;

import org.springframework.stereotype.Service;

import com.vengeang.minipos.dto.CompanyDto;
import com.vengeang.minipos.entity.Company;
import com.vengeang.minipos.exception.ResourceNotFoundException;
import com.vengeang.minipos.mapper.CompanyMapper;
import com.vengeang.minipos.repository.CompanyRepository;
import com.vengeang.minipos.service.CompanyCrudService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CompanyCrudServiceImpl implements CompanyCrudService {
	
	private final CompanyRepository companyRepository;
	private final CompanyMapper companyMapper;
	

	@Override
	public CompanyDto save(CompanyDto data) {
		Company company = companyMapper.toCompany(data);
		company = companyRepository.save(company);
		return companyMapper.toCompanyDto(company);
	}

	@Override
	public CompanyDto getById(Long id) {
		Company company = companyRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("company", id));
		return companyMapper.toCompanyDto(company);
	}

	@Override
	public CompanyDto updateById(Long id, CompanyDto dataUpdate) {
		Company company = companyRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("company", id));
		company.setCompanyAddress(dataUpdate.getCompanyAddress());
		company.setCompanyEmail(dataUpdate.getCompanyEmail());
		company.setCompanyEngName(dataUpdate.getCompanyEngName());
		company.setCompanyLocalName(dataUpdate.getCompanyLocalName());
		company.setCompanyPhone(dataUpdate.getCompanyPhone());
		company.setImage(dataUpdate.getImage());
		company.setImagePath(dataUpdate.getImagePath());
		company.setVatNumber(dataUpdate.getVatNumber());
		company = companyRepository.save(company);
		return companyMapper.toCompanyDto(company);
	}

	@Override
	public void deleteById(Long id) {
		Company company = companyRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("company", id));
		companyRepository.delete(company);
		System.out.println("delete success");
	}

	@Override
	public CompanyDto softDeleteById(Long id) {
		Company company = companyRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("company", id));
		company.setIsDeleted(true);
		company = companyRepository.save(company);
		return companyMapper.toCompanyDto(company);
	}

}
