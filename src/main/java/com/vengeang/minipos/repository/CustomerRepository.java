package com.vengeang.minipos.repository;

import org.springframework.stereotype.Repository;

import com.vengeang.minipos.entity.Customer;

@Repository
public interface CustomerRepository extends GenericRepository<Customer, Long> {

}
