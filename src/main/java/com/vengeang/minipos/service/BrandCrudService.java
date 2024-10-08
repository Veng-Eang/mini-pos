package com.vengeang.minipos.service;

import java.util.List;

import com.vengeang.minipos.dto.BrandDto;

public interface BrandCrudService{
	BrandDto save(BrandDto brand);
	BrandDto getById(Long id);
	BrandDto updateById(Long id,BrandDto brandUpdate);
	List<BrandDto> getAll();
	void deleteById(Long id);
	BrandDto softDeleteById(Long id);
}
