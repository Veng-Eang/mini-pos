package com.vengeang.minipos.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.vengeang.minipos.dto.ProductUnitDto;
import com.vengeang.minipos.entity.ProductUnit;

@Mapper(componentModel = "spring")
public interface ProductUnitMapper {

	@Mapping(target="parentId",source = "parent.id")
	ProductUnitDto toProductUnitDto(ProductUnit productUnit);
	
	ProductUnit toProductUnit(ProductUnitDto productUnitDto);
}
