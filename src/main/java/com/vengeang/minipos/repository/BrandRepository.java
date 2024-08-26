package com.vengeang.minipos.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vengeang.minipos.entity.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long>{
	Optional<Brand> findByIdAndIsDeletedFalse(Long id);
	List<Brand> findAllByIsDeletedFalse();
	Page<Brand> findByNameContainingIgnoreCaseAndIsDeletedFalse(String name, Pageable pageable);
}
