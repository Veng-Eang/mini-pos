package com.vengeang.minipos.service.impl;

import org.springframework.stereotype.Service;

import com.vengeang.minipos.dto.SupplierDto;
import com.vengeang.minipos.entity.Supplier;
import com.vengeang.minipos.exception.ResourceNotFoundException;
import com.vengeang.minipos.mapper.SupplierMapper;
import com.vengeang.minipos.repository.SupplierRepository;
import com.vengeang.minipos.service.SupplierCrudService;

@Service
public class SupplierCrudServiceImpl implements SupplierCrudService {

	private final SupplierRepository supplierRepository;
	private final SupplierMapper supplierMapper;
	public SupplierCrudServiceImpl(SupplierRepository supplierRepository,SupplierMapper supplierMapper) {
		this.supplierRepository = supplierRepository;
		this.supplierMapper = supplierMapper;
	}
	@Override
	public SupplierDto save(SupplierDto data) {
		Supplier supplier = supplierRepository.save(supplierMapper.toSupplier(data));
		return supplierMapper.toSupplierDto(supplier);
	}

	@Override
	public SupplierDto getById(Long id) {
		Supplier supplier = supplierRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Supplier", id));
		return supplierMapper.toSupplierDto(supplier);
	}

	@Override
	public SupplierDto updateById(Long id, SupplierDto dataUpdate) {
		Supplier supplier = supplierRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Supplier", id));
		supplier.setSupplierAddress(dataUpdate.getSupplierAddress());
		supplier.setSupplierEmail(dataUpdate.getSupplierEmail());
		supplier.setSupplierEngName(dataUpdate.getSupplierEngName());
		supplier.setSupplierLocalName(dataUpdate.getSupplierLocalName());
		supplier.setSupplierPhone(dataUpdate.getSupplierPhone());
		supplier.setVatNumber(dataUpdate.getVatNumber());
		supplier = supplierRepository.save(supplier);
		return supplierMapper.toSupplierDto(supplier);
	}

	@Override
	public void deleteById(Long id) {
		Supplier supplier = supplierRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Supplier", id));
		supplierRepository.delete(supplier);
		System.out.println("delete success.");
	}

	@Override
	public SupplierDto softDeleteById(Long id) {
		Supplier supplier = supplierRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Supplier", id));
		supplier.setIsDeleted(true);
		supplier = supplierRepository.save(supplier);
		return supplierMapper.toSupplierDto(supplier);
	}

}
