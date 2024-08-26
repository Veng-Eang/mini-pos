package com.vengeang.minipos.repository;

import org.springframework.stereotype.Repository;

import com.vengeang.minipos.entity.Supplier;

@Repository
public interface SupplierRepository extends GenericRepository<Supplier, Long> {

}
