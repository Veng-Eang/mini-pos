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

import com.vengeang.minipos.dto.PageDto;
import com.vengeang.minipos.dto.SupplierDto;
import com.vengeang.minipos.service.SupplierCrudService;
import com.vengeang.minipos.service.SupplierPaginationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/suppliers")
public class SupplierController {
	private final SupplierCrudService supplierCrudService;
	private final SupplierPaginationService supplierPaginationService;
	@PostMapping
	ResponseEntity<SupplierDto> create(@RequestBody @Validated SupplierDto suplierDto){
		return ResponseEntity.ok(supplierCrudService.save(suplierDto));
	}
	@GetMapping("{id}")
	ResponseEntity<SupplierDto> getById(@PathVariable Long id){
		return ResponseEntity.ok(supplierCrudService.getById(id));
	}
	
	@GetMapping
	ResponseEntity<PageDto> listByPaginationAndSorting(@RequestParam Map<String,String> params){
		return ResponseEntity.ok(supplierPaginationService.listByPaginationAndSorting(params));
	}
	
	
	@PutMapping("{id}")
	ResponseEntity<SupplierDto> updateById(@PathVariable Long id,@RequestBody @Validated SupplierDto supplierDto){
		return ResponseEntity.ok(supplierCrudService.updateById(id, supplierDto));
	}
	
	@DeleteMapping("{id}")
	ResponseEntity<String> deleteById(@PathVariable Long id){
		supplierCrudService.softDeleteById(id);
		return ResponseEntity.ok("Move supplier with id : "+id+" to trash success.");
	}
}
