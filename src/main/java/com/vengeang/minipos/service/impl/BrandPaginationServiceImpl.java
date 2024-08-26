package com.vengeang.minipos.service.impl;

import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.vengeang.minipos.dto.BrandDto;
import com.vengeang.minipos.dto.PageDto;
import com.vengeang.minipos.entity.Brand;
import com.vengeang.minipos.mapper.BrandMapper;
import com.vengeang.minipos.repository.BrandRepository;
import com.vengeang.minipos.service.BrandPaginationService;
import com.vengeang.minipos.utils.PageUtil;
import com.vengeang.minipos.utils.constant.StringConst.PageConst;

@Service
public class BrandPaginationServiceImpl implements BrandPaginationService {
	private final BrandRepository brandRepository;
	private final BrandMapper brandMapper;
	public BrandPaginationServiceImpl(BrandRepository brandRepository,BrandMapper brandMapper) {
		this.brandRepository = brandRepository;
		this.brandMapper = brandMapper;
	}
	@Override
	public PageDto getAllWithPagination(Map<String, String> params) {
		String searchName = PageConst.SEARCH_NAME;
		
		 // Create Pageable object
        Pageable pageable = PageUtil.getPageable(params);

        // Fetch paginated result
        Page<Brand> brandPage;
        if (params.containsKey(searchName)) {
            String name = params.get(searchName);
            brandPage = brandRepository.findByNameContainingIgnoreCaseAndIsDeletedFalse(name, pageable);
        } else {
            brandPage = brandRepository.findByNameContainingIgnoreCaseAndIsDeletedFalse(PageConst.DEFAULT_SEARCH_NAME,pageable);
        }
        Page<BrandDto> brandDtoPage = brandPage.map(b->brandMapper.toBrandDto(b));
		PageDto pageDto = new PageDto(brandDtoPage);
		return pageDto;
	}
}
