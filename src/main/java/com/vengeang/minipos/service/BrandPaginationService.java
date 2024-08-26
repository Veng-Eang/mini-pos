package com.vengeang.minipos.service;

import java.util.Map;

import com.vengeang.minipos.dto.PageDto;

public interface BrandPaginationService {
	PageDto getAllWithPagination(Map<String, String> params);
}
