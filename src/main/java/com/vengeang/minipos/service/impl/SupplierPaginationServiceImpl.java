package com.vengeang.minipos.service.impl;

import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.vengeang.minipos.dto.PageDto;
import com.vengeang.minipos.dto.SupplierDto;
import com.vengeang.minipos.entity.Supplier;
import com.vengeang.minipos.mapper.SupplierMapper;
import com.vengeang.minipos.repository.SupplierRepository;
import com.vengeang.minipos.service.SupplierPaginationService;
import com.vengeang.minipos.utils.PageUtil;

@Service
public class SupplierPaginationServiceImpl implements SupplierPaginationService {
	private final SupplierRepository supplierRepository;
	private final SupplierMapper supplierMapper;
	public SupplierPaginationServiceImpl(SupplierRepository supplierRepository,SupplierMapper supplierMapper) {
		this.supplierRepository = supplierRepository;
		this.supplierMapper = supplierMapper;
	}

	@Override
	public PageDto listByPaginationAndSorting(Map<String, String> param) {
		Pageable pageable = PageUtil.getPageable(param);
		Page<Supplier> supplierPage = supplierRepository.findByIsDeletedFalse(pageable);
		Page<SupplierDto> supplierPageDto = supplierPage.map(s->supplierMapper.toSupplierDto(s));
		return new PageDto(supplierPageDto);
	}

}
