package com.vengeang.minipos.service.impl;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.vengeang.minipos.dto.CategoryDto;
import com.vengeang.minipos.entity.Category;
import com.vengeang.minipos.exception.ResourceNotFoundException;
import com.vengeang.minipos.mapper.CategoryMapper;
import com.vengeang.minipos.repository.CategoryRepository;
import com.vengeang.minipos.service.CategoryUploadImageService;
import com.vengeang.minipos.utils.FileUploadUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryUploadImageServiceImpl implements CategoryUploadImageService {
	private final CategoryRepository categoryRepository;
	private final CategoryMapper categoryMapper;
	@Value("${file.server-path}")
	private String fileServerPath;
	@Override
	public CategoryDto uploadImage(Long id, MultipartFile multipartFile) throws IllegalStateException, IOException {
		Category category = categoryRepository.findByIdAndIsDeletedFalse(id).orElseThrow(()->new ResourceNotFoundException("Category", id));
		String fileName = FileUploadUtil.saveFile(fileServerPath, multipartFile);
		category.setImagePath(fileName);
		category = categoryRepository.save(category);
		return categoryMapper.toCategoryDto(category);
	}

}
