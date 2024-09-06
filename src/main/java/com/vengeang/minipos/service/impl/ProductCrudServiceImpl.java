package com.vengeang.minipos.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vengeang.minipos.dto.ProductDto;
import com.vengeang.minipos.entity.Brand;
import com.vengeang.minipos.entity.Category;
import com.vengeang.minipos.entity.EnumProductType;
import com.vengeang.minipos.entity.Product;
import com.vengeang.minipos.exception.ResourceNotFoundException;
import com.vengeang.minipos.mapper.ProductMapper;
import com.vengeang.minipos.repository.BrandRepository;
import com.vengeang.minipos.repository.CategoryRepository;
import com.vengeang.minipos.repository.ProductRepository;
import com.vengeang.minipos.service.ProductCrudService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductCrudServiceImpl implements ProductCrudService {

	private final ProductRepository productRepository;
	private final ProductMapper productMapper;
	private final BrandRepository brandRepository;
	private final CategoryRepository categoryRepository;

	@Override
	public ProductDto save(ProductDto data) {
		Product product = productMapper.toProduct(data);
		Category category = categoryRepository.findByIdAndIsDeletedFalse(data.getCategoryId())
				.orElseThrow(() -> new ResourceNotFoundException("Category", data.getCategoryId()));
		Brand brand = brandRepository.findByIdAndIsDeletedFalse(data.getBrandId())
				.orElseThrow(() -> new ResourceNotFoundException("Brand", data.getBrandId()));
		product.setBrand(brand);
		product.setCategory(category);
		product = productRepository.save(product);
		return productMapper.toProductDto(product);
	}

	@Override
	public ProductDto getById(Long id) {
		Product product = productRepository.findByIdAndIsDeletedFalse(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product", id));
		return productMapper.toProductDto(product);
	}

	@Override
	public ProductDto updateById(Long id, ProductDto dataUpdate) {
		Product product = productRepository.findByIdAndIsDeletedFalse(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product", id));
		Category category = categoryRepository.findByIdAndIsDeletedFalse(dataUpdate.getCategoryId())
				.orElseThrow(() -> new ResourceNotFoundException("Category", dataUpdate.getCategoryId()));
		Brand brand = brandRepository.findByIdAndIsDeletedFalse(dataUpdate.getBrandId())
				.orElseThrow(() -> new ResourceNotFoundException("Brand", dataUpdate.getBrandId()));
		product.setName(dataUpdate.getName());
		product.setCode(dataUpdate.getCode());
		product.setType(EnumProductType.valueOf(dataUpdate.getType().toUpperCase()));
		product.setBrand(brand);
		product.setCategory(category);
		product = productRepository.save(product);
		return productMapper.toProductDto(product);
	}

	@Override
	public List<ProductDto> getAll() {
		throw new UnsupportedOperationException("no longer aviable");
	}

	@Override
	public void deleteById(Long id) {
		Product product = productRepository.findByIdAndIsDeletedFalse(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product", id));
		productRepository.delete(product);
		System.out.println("deleted success");
	}

	@Override
	public ProductDto softDeleteById(Long id) {
		Product product = productRepository.findByIdAndIsDeletedFalse(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product", id));
		product.setIsDeleted(true);
		product = productRepository.save(product);
		return productMapper.toProductDto(product);
	}

}
