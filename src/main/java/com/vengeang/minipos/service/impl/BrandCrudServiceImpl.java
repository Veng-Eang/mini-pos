package com.vengeang.minipos.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.vengeang.minipos.entity.Brand;
import com.vengeang.minipos.repository.BrandRepository;
import com.vengeang.minipos.service.BrandCrudService;

@Service
public class BrandCrudServiceImpl implements BrandCrudService{
	
	private final BrandRepository brandRepository;
	
	public BrandCrudServiceImpl(BrandRepository brandRepository) {
		this.brandRepository = brandRepository;
	}



}
