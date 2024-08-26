package com.vengeang.minipos.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vengeang.minipos.dto.CompanyDto;
import com.vengeang.minipos.service.CompanyCrudService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/companies")
public class CompanyController {
	private final CompanyCrudService companyCrudService;
	
	@PostMapping
	ResponseEntity<CompanyDto> create(@RequestBody @Validated CompanyDto companyDto){
		return ResponseEntity.ok(companyCrudService.save(companyDto));
	}
	@GetMapping("{id}")
	ResponseEntity<CompanyDto> getById(@PathVariable Long id){
		return ResponseEntity.ok(companyCrudService.getById(id));
	}
	
	
	@PutMapping("{id}")
	ResponseEntity<CompanyDto> updateById(@PathVariable Long id,@RequestBody @Validated CompanyDto companyUpdate){
		return ResponseEntity.ok(companyCrudService.updateById(id, companyUpdate));
	}
	
	@DeleteMapping("{id}")
	ResponseEntity<String> deleteById(@PathVariable Long id){
		companyCrudService.softDeleteById(id);
		return ResponseEntity.ok("Move company with id : "+id+" to trash success.");
	}
}
