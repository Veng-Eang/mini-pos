package com.vengeang.minipos.dto;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class BrandDto {
	
	private Long id;
	@NotBlank(message = "Name is can not empty!")
    @Length(min = 2, max = 64, message = "Name must be greater them 2 characters and less then 64 characters!")
	private String name;
}
