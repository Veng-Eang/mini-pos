package com.vengeang.minipos.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.vengeang.minipos.dto.BrandDto;
import com.vengeang.minipos.entity.Brand;
import com.vengeang.minipos.exception.ResourceNotFoundException;
import com.vengeang.minipos.mapper.BrandMapper;
import com.vengeang.minipos.repository.BrandRepository;
import com.vengeang.minipos.service.BrandCrudService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BrandCrudServiceImpl implements BrandCrudService{
	
	private final BrandRepository brandRepository;
	private final BrandMapper brandMapper;
	

	@Override
	public BrandDto save(BrandDto brand) {
		Brand brandsave = brandMapper.toBrand(brand);
		brandsave.setIsDeleted(false);
		brandsave = brandRepository.save(brandsave);
		return brandMapper.toBrandDto(brandsave);
	}

	@Override
	public BrandDto getById(Long id) {
		Brand brand = brandRepository.findByIdAndIsDeletedFalse(id)
				.orElseThrow(() -> new ResourceNotFoundException("Brand", id));
		return brandMapper.toBrandDto(brand);
	}

	@Override
	public List<BrandDto> getAll() {
		return brandRepository.findAllByIsDeletedFalse().stream().map(b->brandMapper.toBrandDto(b)).collect(Collectors.toList());
	}
	
	@Override
	public BrandDto updateById(Long id, BrandDto brandUpdate) {
		Brand brand = brandRepository.findByIdAndIsDeletedFalse(id)
				.orElseThrow(() -> new ResourceNotFoundException("Brand", id));
		brand.setName(brandUpdate.getName());
		return brandMapper.toBrandDto(brandRepository.save(brand));
	}

	@Override
	public void deleteById(Long id) {
		Brand byIdBrand =  brandRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Brand", id));
		 brandRepository.delete(byIdBrand);
	}
	@Override
	public BrandDto softDeleteById(Long id) {
		Brand byIdBrand =  brandRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Brand", id));
		byIdBrand.setIsDeleted(true);
		return brandMapper.toBrandDto(brandRepository.save(byIdBrand));
	}
}
