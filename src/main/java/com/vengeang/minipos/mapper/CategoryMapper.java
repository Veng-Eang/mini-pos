package com.vengeang.minipos.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.vengeang.minipos.dto.CategoryDto;
import com.vengeang.minipos.entity.Category;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

	@Mapping(target = "parentId",source = "parent.id")
	CategoryDto toCategoryDto(Category category);
	Category toCategory(CategoryDto categoryDto);
}
