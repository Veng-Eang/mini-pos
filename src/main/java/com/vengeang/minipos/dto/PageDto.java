package com.vengeang.minipos.dto;

import java.util.List;

import org.springframework.data.domain.Page;

import lombok.Data;
@Data
public class PageDto {
    private List<?> content;
    private PaginationDto pagination;

    public PageDto(Page<?> page) {
        this.content = page.getContent();
        this.pagination = PaginationDto.builder()
                .empty(page.isEmpty())
                .first(page.isFirst())
                .last(page.isLast())
                .pageSize(page.getPageable().getPageSize())
                .pageNumber(page.getPageable().getPageNumber() + 1)
                .totalPages(page.getTotalPages())
                .totalElements(page.getTotalElements())
                .numberOfElements(page.getNumberOfElements())
                .build();
    }
}
