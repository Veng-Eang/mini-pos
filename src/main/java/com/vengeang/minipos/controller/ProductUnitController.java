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

import com.vengeang.minipos.dto.ProductUnitDto;
import com.vengeang.minipos.service.ProductUnitCrudService;

import lombok.RequiredArgsConstructor;
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/products_unit")
public class ProductUnitController {
	
	private final ProductUnitCrudService productUnitCrudService;
	@PostMapping
	ResponseEntity<ProductUnitDto> create(@RequestBody @Validated ProductUnitDto productUnitDto){
		return ResponseEntity.ok(productUnitCrudService.save(productUnitDto));
	}
	@GetMapping("{id}")
	ResponseEntity<ProductUnitDto> getById(@PathVariable Long id){
		return ResponseEntity.ok(productUnitCrudService.getById(id));
	}
	
	@PutMapping("{id}")
	ResponseEntity<ProductUnitDto> updateById(@PathVariable Long id,@RequestBody @Validated ProductUnitDto productUnitDto){
		return ResponseEntity.ok(productUnitCrudService.updateById(id, productUnitDto));
	}
	
	@DeleteMapping("{id}")
	ResponseEntity<String> deleteById(@PathVariable Long id){
		productUnitCrudService.softDeleteById(id);
		return ResponseEntity.ok("Move Product Unit with id : "+id+" to trash success.");
	}
}
