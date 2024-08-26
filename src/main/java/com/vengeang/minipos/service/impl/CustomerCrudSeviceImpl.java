package com.vengeang.minipos.service.impl;

import org.springframework.stereotype.Service;

import com.vengeang.minipos.dto.CustomerDto;
import com.vengeang.minipos.entity.Customer;
import com.vengeang.minipos.exception.ResourceNotFoundException;
import com.vengeang.minipos.mapper.CustomerMapper;
import com.vengeang.minipos.repository.CustomerRepository;
import com.vengeang.minipos.service.CustomerCrudService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerCrudSeviceImpl implements CustomerCrudService {
	
	private final CustomerRepository customerRepository;
	private final CustomerMapper customerMapper;

	@Override
	public CustomerDto save(CustomerDto data) {
		Customer customer = customerRepository.save(customerMapper.toCustomer(data));
		return customerMapper.toCustomerDto(customer);
	}

	@Override
	public CustomerDto getById(Long id) {
		Customer customer = customerRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Customer", id));
		return customerMapper.toCustomerDto(customer);
	}

	@Override
	public CustomerDto updateById(Long id, CustomerDto dataUpdate) {
		Customer customer = customerRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Customer", id));
		customer.setCustomerAddress(dataUpdate.getCustomerAddress());
		customer.setCustomerEmail(dataUpdate.getCustomerEmail());
		customer.setCustomerEngName(dataUpdate.getCustomerEngName());
		customer.setCustomerLocalName(dataUpdate.getCustomerLocalName());
		customer.setCustomerPhone(dataUpdate.getCustomerPhone());
		customer = customerRepository.save(customer);
		return customerMapper.toCustomerDto(customer);
	}

	@Override
	public void deleteById(Long id) {
		Customer customer = customerRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Customer", id));
		customerRepository.delete(customer);
		System.out.println("deleted success.");
	}

	@Override
	public CustomerDto softDeleteById(Long id) {
		Customer customer = customerRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Customer", id));
		customer.setIsDeleted(true);
		customer = customerRepository.save(customer);
		return customerMapper.toCustomerDto(customer);
	}

}
