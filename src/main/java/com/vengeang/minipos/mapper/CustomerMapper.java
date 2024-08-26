package com.vengeang.minipos.mapper;

import org.mapstruct.Mapper;

import com.vengeang.minipos.dto.CustomerDto;
import com.vengeang.minipos.entity.Customer;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
	CustomerDto toCustomerDto(Customer customer);
	Customer toCustomer(CustomerDto customerDto);
}
