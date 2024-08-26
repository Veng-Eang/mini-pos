package com.vengeang.minipos.controller;

import java.util.List;
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

import com.vengeang.minipos.dto.BrandDto;
import com.vengeang.minipos.dto.PageDto;
import com.vengeang.minipos.service.BrandCrudService;
import com.vengeang.minipos.service.BrandPaginationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/brands")
@RequiredArgsConstructor
public class BrandController {
	private final BrandCrudService brandCrudService;
	private final BrandPaginationService brandPaginationService;
	@PostMapping
	ResponseEntity<BrandDto> create(@RequestBody @Validated BrandDto brandDto){
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
	
	@GetMapping("page")
	ResponseEntity<PageDto> listAllByPage(@RequestParam Map<String, String> params){
		return ResponseEntity.ok(brandPaginationService.getAllWithPagination(params));
	}
	
	
	@PutMapping("{id}")
	ResponseEntity<BrandDto> updateById(@PathVariable Long id,@RequestBody @Validated BrandDto brandUpdate){
		return ResponseEntity.ok(brandCrudService.updateById(id, brandUpdate));
	}
	
	@DeleteMapping("{id}")
	ResponseEntity<String> deleteById(@PathVariable Long id){
		brandCrudService.softDeleteById(id);
		return ResponseEntity.ok("Move brand with id : "+id+" to trash success.");
	}
}
