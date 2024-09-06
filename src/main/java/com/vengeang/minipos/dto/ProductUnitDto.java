package com.vengeang.minipos.dto;

import java.util.List;

import com.vengeang.minipos.entity.ProductUnit;

import lombok.Data;

@Data
public class ProductUnitDto {
	private Long id;

	private String code;
	
    private String name;
    
    private String operator;

    private Double operationValue;

    private Long parentId;
    
    private List<ProductUnit> children;
}
