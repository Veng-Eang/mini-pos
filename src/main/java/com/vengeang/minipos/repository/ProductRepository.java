package com.vengeang.minipos.repository;

import org.springframework.stereotype.Repository;

import com.vengeang.minipos.entity.Product;

@Repository
public interface ProductRepository extends GenericRepository<Product, Long>{

}
