package com.vengeang.minipos.service;

import java.util.List;

public interface GenericCrudService<T> {
	T save(T data);
	T getById(Long id);
	T updateById(Long id,T dataUpdate);
	List<T> getAll();
	void deleteById(Long id);
	T softDeleteById(Long id);
}
