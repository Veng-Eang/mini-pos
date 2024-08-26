package com.vengeang.minipos.mapper;

import org.mapstruct.Mapper;

import com.vengeang.minipos.dto.SupplierDto;
import com.vengeang.minipos.entity.Supplier;

@Mapper(componentModel = "spring")
public interface SupplierMapper {
	SupplierDto toSupplierDto(Supplier supplier);
	Supplier toSupplier(SupplierDto supplierDto);
}
