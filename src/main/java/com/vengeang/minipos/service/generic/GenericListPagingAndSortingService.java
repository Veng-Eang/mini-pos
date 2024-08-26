package com.vengeang.minipos.service.generic;

import java.util.Map;

public interface GenericListPagingAndSortingService<T> {
	T listByPaginationAndSorting(Map<String, String> param);
}
