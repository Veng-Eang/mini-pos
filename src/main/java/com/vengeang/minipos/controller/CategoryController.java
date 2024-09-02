package com.vengeang.minipos.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.vengeang.minipos.dto.CategoryDto;
import com.vengeang.minipos.service.CategoryCrudService;
import com.vengeang.minipos.service.CategoryUploadImageService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/categories")
public class CategoryController {
	private final CategoryCrudService categoryCrudService;
	private final CategoryUploadImageService categoryUploadImageService;
	
	@PostMapping
	public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto){
		return ResponseEntity.ok(categoryCrudService.save(categoryDto));
	}
	
	@PostMapping("{id}/image")
	public ResponseEntity<CategoryDto> uploadImage(@PathVariable Long id,@RequestParam MultipartFile file) throws IllegalStateException, IOException{
		return ResponseEntity.ok(categoryUploadImageService.uploadImage(id, file));
	}
	
	@GetMapping("{id}")
	public ResponseEntity<CategoryDto> getById(@PathVariable Long id){
		return ResponseEntity.ok(categoryCrudService.getById(id));
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<CategoryDto>> getAll(){
		return ResponseEntity.ok(categoryCrudService.getAll());
	}
	@PutMapping("{id}")
	public ResponseEntity<CategoryDto> updateById(@PathVariable Long id, @RequestBody CategoryDto categoryDto){
		return ResponseEntity.ok(categoryCrudService.updateById(id, categoryDto));
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<CategoryDto> deleteById(@PathVariable Long id){
		return ResponseEntity.ok(categoryCrudService.softDeleteById(id));
	}
	
	
}
