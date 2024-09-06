package com.vengeang.minipos.service.impl;

import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;

import com.vengeang.minipos.dto.ProductUnitDto;
import com.vengeang.minipos.entity.EnumProductUnit;
import com.vengeang.minipos.entity.ProductUnit;
import com.vengeang.minipos.exception.ResourceNotFoundException;
import com.vengeang.minipos.mapper.ProductUnitMapper;
import com.vengeang.minipos.repository.ProductUnitRepository;
import com.vengeang.minipos.service.ProductUnitCrudService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductUnitCrudServiceImpl implements ProductUnitCrudService {
	
	private final ProductUnitRepository productUnitRepository;
	private final ProductUnitMapper productUnitMapper;
	

	@Override
	public ProductUnitDto save(ProductUnitDto data) {
		ProductUnit productUnit = productUnitMapper.toProductUnit(data);
		if(!Objects.isNull(data.getParentId())) {
			ProductUnit parent = productUnitRepository.findByIdAndIsDeletedFalse(data.getParentId()).orElseThrow(()-> new ResourceNotFoundException("Product Unit", data.getParentId()));
			productUnit.setParent(parent);
		}
		productUnit = productUnitRepository.save(productUnit);
		return productUnitMapper.toProductUnitDto(productUnit);
	}

	@Override
	public ProductUnitDto getById(Long id) {
		ProductUnit productUnit = productUnitRepository.findByIdAndIsDeletedFalse(id).orElseThrow(()-> new ResourceNotFoundException("Product Unit", id));
		return productUnitMapper.toProductUnitDto(productUnit);
	}

	@Override
	public ProductUnitDto updateById(Long id, ProductUnitDto dataUpdate) {
		ProductUnit productUnit = productUnitRepository.findByIdAndIsDeletedFalse(id).orElseThrow(()-> new ResourceNotFoundException("Product Unit", id));
		productUnit.setName(dataUpdate.getName());
		productUnit.setOperationValue(dataUpdate.getOperationValue());
		productUnit.setOperator(EnumProductUnit.valueOf(dataUpdate.getOperator().toUpperCase()));
		productUnit.setParent(null);
		if(!Objects.isNull(dataUpdate.getParentId())) {
			ProductUnit parent = productUnitRepository.findByIdAndIsDeletedFalse(dataUpdate.getParentId()).orElseThrow(()-> new ResourceNotFoundException("Product Unit", dataUpdate.getParentId()));
			productUnit.setParent(parent);
		}
		productUnit = productUnitRepository.save(productUnit);
		return productUnitMapper.toProductUnitDto(productUnit);
	}

	@Override
	public List<ProductUnitDto> getAll() {
		throw new UnsupportedOperationException("on longer aviable");
	}

	@Override
	public void deleteById(Long id) {
		ProductUnit productUnit = productUnitRepository.findByIdAndIsDeletedFalse(id).orElseThrow(()-> new ResourceNotFoundException("Product Unit", id));
		productUnitRepository.delete(productUnit);
		System.out.println("delete success");
	}

	@Override
	public ProductUnitDto softDeleteById(Long id) {
		ProductUnit productUnit = productUnitRepository.findByIdAndIsDeletedFalse(id).orElseThrow(()-> new ResourceNotFoundException("Product Unit", id));
		productUnit.setIsDeleted(true);
		productUnit = productUnitRepository.save(productUnit);
		return productUnitMapper.toProductUnitDto(productUnit);
	}

}
