package com.vengeang.minipos.repository;

import org.springframework.stereotype.Repository;

import com.vengeang.minipos.entity.Category;

@Repository
public interface CategoryRepository extends GenericRepository<Category, Long> {

}
