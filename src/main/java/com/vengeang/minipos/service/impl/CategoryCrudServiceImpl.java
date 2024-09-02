package com.vengeang.minipos.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.vengeang.minipos.dto.CategoryDto;
import com.vengeang.minipos.entity.Category;
import com.vengeang.minipos.exception.ResourceNotFoundException;
import com.vengeang.minipos.mapper.CategoryMapper;
import com.vengeang.minipos.repository.CategoryRepository;
import com.vengeang.minipos.service.CategoryCrudService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryCrudServiceImpl implements CategoryCrudService {
	
	private final CategoryRepository categoryRepository;
	private final CategoryMapper categoryMapper;

	@Override
	public CategoryDto save(CategoryDto data) {
		Category category = categoryMapper.toCategory(data);
		if(!Objects.isNull(data.getParentId())) {
			Category parentCategory = categoryRepository.findByIdAndIsDeletedFalse(data.getParentId()).orElseThrow(()-> new ResourceNotFoundException("Category", data.getParentId()));
			category.setParent(parentCategory);
		}
		return categoryMapper.toCategoryDto(categoryRepository.save(category));
	}

	@Override
	public CategoryDto getById(Long id) {
		Category category = categoryRepository.findByIdAndIsDeletedFalse(id).orElseThrow(()-> new ResourceNotFoundException("Category", id));
		return categoryMapper.toCategoryDto(category);
	}

	@Override
	public CategoryDto updateById(Long id, CategoryDto dataUpdate) {
		Category category = categoryRepository.findByIdAndIsDeletedFalse(id).orElseThrow(()-> new ResourceNotFoundException("Category", id));
		category.setCode(dataUpdate.getCode());
		category.setImagePath(dataUpdate.getImagePath());
		category.setName(dataUpdate.getName());
		if(dataUpdate.getParentId() != null) {
			Category parentCategory = categoryRepository.findByIdAndIsDeletedFalse(dataUpdate.getParentId()).orElseThrow(()-> new ResourceNotFoundException("Category", dataUpdate.getParentId()));	
			category.setParent(parentCategory);
		}
		return categoryMapper.toCategoryDto(categoryRepository.save(category));
	}

	@Override
	public List<CategoryDto> getAll() {
		List<Category> categories = categoryRepository.findAllByIsDeletedFalse();
		
		List<CategoryDto> categoriesDto = categories.stream()
				.filter(c->c.getParent() == null)
				.map(categoryMapper::toCategoryDto)
				.collect(Collectors.toList());
		
		return categoriesDto;
	}

	@Override
	public void deleteById(Long id) {
		Category category = categoryRepository.findByIdAndIsDeletedFalse(id).orElseThrow(()-> new ResourceNotFoundException("Category", id));
		categoryRepository.delete(category);
		System.out.println("delete success.");
	}

	@Override
	public CategoryDto softDeleteById(Long id) {
		Category category = categoryRepository.findByIdAndIsDeletedFalse(id).orElseThrow(()-> new ResourceNotFoundException("Category", id));
		category.setIsDeleted(true);
		category = categoryRepository.save(category);
		return categoryMapper.toCategoryDto(category);
	}

}
