package com.vengeang.minipos.dto;

import lombok.Data;

@Data
public class ProductDto {
	private Long id;
	
    private String name;

    private String code;

    private Long categoryId;

    private Long brandId;

    private String type;

//    private String barcodeSymbology;
//
//    private Double cost;
//
//    private Double price;
//
//    private Integer qty;
//
//    private Integer alertQty;
//
//    private String imagePath;
//
//    private String image;
//
//    private boolean isOverridePrice;
//
//    private boolean isShowInPos;
}
