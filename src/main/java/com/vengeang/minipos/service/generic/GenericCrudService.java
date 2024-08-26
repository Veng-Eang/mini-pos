package com.vengeang.minipos.service.generic;

public interface GenericCrudService<T> {
	T save(T data);
	T getById(Long id);
	T updateById(Long id,T dataUpdate);
	void deleteById(Long id);
	T softDeleteById(Long id);
}
	