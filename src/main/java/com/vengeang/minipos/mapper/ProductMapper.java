package com.vengeang.minipos.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.vengeang.minipos.dto.ProductDto;
import com.vengeang.minipos.entity.Product;

@Mapper(componentModel = "spring")
public interface ProductMapper {
	
	@Mapping(target = "brandId",source = "brand.id")
	@Mapping(target = "categoryId",source = "category.id")
	ProductDto toProductDto(Product product);

	Product toProduct(ProductDto productDto);
}
