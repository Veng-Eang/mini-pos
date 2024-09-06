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

import com.vengeang.minipos.dto.ProductDto;
import com.vengeang.minipos.service.ProductCrudService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/products")
public class ProductController {

	private final ProductCrudService productCrudService;
	
	@PostMapping
	ResponseEntity<ProductDto> create(@RequestBody @Validated ProductDto productDto){
		return ResponseEntity.ok(productCrudService.save(productDto));
	}
	@GetMapping("{id}")
	ResponseEntity<ProductDto> getById(@PathVariable Long id){
		return ResponseEntity.ok(productCrudService.getById(id));
	}
	
	@PutMapping("{id}")
	ResponseEntity<ProductDto> updateById(@PathVariable Long id,@RequestBody @Validated ProductDto productDto){
		return ResponseEntity.ok(productCrudService.updateById(id, productDto));
	}
	
	@DeleteMapping("{id}")
	ResponseEntity<String> deleteById(@PathVariable Long id){
		productCrudService.softDeleteById(id);
		return ResponseEntity.ok("Move Product with id : "+id+" to trash success.");
	}
}
