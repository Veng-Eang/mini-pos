package com.vengeang.minipos.repository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface GenericRepository<T,ID extends Serializable> extends JpaRepository<T, ID> {
	Optional<T> findByIdAndIsDeletedFalse(Long id);
	List<T> findAllByIsDeletedFalse();
	Page<T> findByIsDeletedFalse(Pageable pageable);
}
