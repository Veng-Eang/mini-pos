package com.vengeang.minipos.mapper;

import org.mapstruct.Mapper;

import com.vengeang.minipos.dto.BrandDto;
import com.vengeang.minipos.entity.Brand;

@Mapper(componentModel = "spring")
public interface BrandMapper {
	
	BrandDto toBrandDto(Brand brand);
	Brand toBrand(BrandDto brandDto);
}
