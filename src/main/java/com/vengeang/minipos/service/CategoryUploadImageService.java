package com.vengeang.minipos.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.vengeang.minipos.dto.CategoryDto;

public interface CategoryUploadImageService {
	CategoryDto uploadImage(Long id,MultipartFile multipartFile) throws IllegalStateException, IOException;
}
