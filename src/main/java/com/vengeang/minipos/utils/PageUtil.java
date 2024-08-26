package com.vengeang.minipos.utils;

import java.util.Map;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import static com.vengeang.minipos.utils.constant.StringConst.PageConst.*;;

public interface PageUtil {
	static Pageable getPageable(Map<String,String> params){
        int pageNo = DEFAULT_PAGE_NUMBER;
        int pageSize = DEFAULT_PAGE_SIZE;
        String sortDir = DEFAULT_SORT_DIRECTION;
        String sortBy = DEFAULT_SORT_BY;

        // check params contain or not for page size
		if(params.containsKey(PAGE_SIZE))
		{
			try {
				pageSize = Integer.parseInt(params.get(PAGE_SIZE));
			if(pageSize < 1) {
				pageSize = DEFAULT_PAGE_SIZE;
			}
			} catch (Exception e) {
				pageSize = DEFAULT_PAGE_SIZE;
			}
		}

		// check params contain or not for page number
		if(params.containsKey(PAGE_NUMBER))
		{
			
			try {
				pageNo = Integer.parseInt(params.get(PAGE_NUMBER));
			if(pageNo < 1 ) {
				pageNo = DEFAULT_PAGE_NUMBER;
			}
			} catch (Exception e) {
				pageNo = DEFAULT_PAGE_NUMBER;
			}
		}


		// check params contain or not for sort direction
		if(params.containsKey(SORT_DIRECTION))
		{
			sortDir = params.get(SORT_DIRECTION);
			if(sortDir.isEmpty() || sortDir == null){
				sortDir = DEFAULT_SORT_DIRECTION;
			}
		}
		if(params.containsKey(SORT_BY))
		{
			sortBy = params.get(SORT_BY);
			if(sortBy.isEmpty() || sortBy == null){
				sortBy = DEFAULT_SORT_BY;
			}
		}
		
		Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) 
				           ? Sort.by(sortBy).ascending() 
				           : Sort.by(sortBy).descending();
        return PageRequest.of(pageNo-1, pageSize, sort);
    }
}
