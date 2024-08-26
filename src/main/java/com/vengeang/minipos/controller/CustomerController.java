package com.vengeang.minipos.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vengeang.minipos.dto.CustomerDto;
import com.vengeang.minipos.dto.PageDto;
import com.vengeang.minipos.service.CustomerCrudService;
import com.vengeang.minipos.service.CustomerPaginationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/customers")
public class CustomerController {
	private final CustomerCrudService customerCrudService;
	private final CustomerPaginationService customerPaginationService;

	@PostMapping
	ResponseEntity<CustomerDto> create(@RequestBody @Validated CustomerDto companyDto) {
		return ResponseEntity.ok(customerCrudService.save(companyDto));
	}

	@GetMapping("{id}")
	ResponseEntity<CustomerDto> getById(@PathVariable Long id) {
		return ResponseEntity.ok(customerCrudService.getById(id));
	}

	@GetMapping
	ResponseEntity<PageDto> listByPaginationAndSorting(@RequestParam Map<String, String> params) {
		return ResponseEntity.ok(customerPaginationService.listByPaginationAndSorting(params));
	}

	@PutMapping("{id}")
	ResponseEntity<CustomerDto> updateById(@PathVariable Long id, @RequestBody @Validated CustomerDto customerUpdate) {
		return ResponseEntity.ok(customerCrudService.updateById(id, customerUpdate));
	}

	@DeleteMapping("{id}")
	ResponseEntity<String> deleteById(@PathVariable Long id) {
		customerCrudService.softDeleteById(id);
		return ResponseEntity.ok("Move customer with id : " + id + " to trash success.");
	}
}
