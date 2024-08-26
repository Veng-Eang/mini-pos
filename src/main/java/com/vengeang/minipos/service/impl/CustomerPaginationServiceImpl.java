package com.vengeang.minipos.service.impl;

import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.vengeang.minipos.dto.CustomerDto;
import com.vengeang.minipos.dto.PageDto;
import com.vengeang.minipos.entity.Customer;
import com.vengeang.minipos.mapper.CustomerMapper;
import com.vengeang.minipos.repository.CustomerRepository;
import com.vengeang.minipos.service.CustomerPaginationService;
import com.vengeang.minipos.utils.PageUtil;

@Service
public class CustomerPaginationServiceImpl implements CustomerPaginationService {
	private final CustomerRepository customerRepository;
	private final CustomerMapper customerMapper;
	public CustomerPaginationServiceImpl(CustomerRepository customerRepository,CustomerMapper customerMapper) {
		this.customerRepository = customerRepository;
		this.customerMapper = customerMapper;
	}
	@Override
	public PageDto listByPaginationAndSorting(Map<String, String> param) {
		Pageable pageable = PageUtil.getPageable(param);
		Page<Customer> pageCustomer = customerRepository.findByIsDeletedFalse(pageable);
		Page<CustomerDto> pageCustomerDto = pageCustomer.map(c->customerMapper.toCustomerDto(c));
		return new PageDto(pageCustomerDto);
	}

}
