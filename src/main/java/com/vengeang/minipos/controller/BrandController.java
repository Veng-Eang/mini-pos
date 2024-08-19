package com.vengeang.minipos.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vengeang.minipos.dto.BrandDto;
import com.vengeang.minipos.service.BrandCrudService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/brands")
@RequiredArgsConstructor
public class BrandController {
	private final BrandCrudService brandCrudService;
	@PostMapping
	ResponseEntity<BrandDto> create(@RequestBody BrandDto brandDto){
		return ResponseEntity.ok(brandCrudService.save(brandDto));
	}
	@GetMapping
	ResponseEntity<List<BrandDto>> listAll(){
		return ResponseEntity.ok(brandCrudService.getAll());
	}
	@GetMapping("{id}")
	ResponseEntity<BrandDto> getById(@PathVariable Long id){
		return ResponseEntity.ok(brandCrudService.getById(id));
	}
	@DeleteMapping("{id}")
	ResponseEntity<String> deleteById(@PathVariable Long id){
		brandCrudService.deleteById(id);
		return ResponseEntity.ok("Delete brand with id : "+id+" success.");
	}
}
