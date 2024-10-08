package com.vengeang.minipos.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PaginationDto {
    private int pageSize;
    private int pageNumber;
    private int totalPages;
    private long totalElements;
    private long numberOfElements;
    private boolean first;
    private boolean last;
    private boolean empty;
}
