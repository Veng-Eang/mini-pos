package com.vengeang.minipos.dto;

import java.util.List;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CategoryDto {
	private Long id;
    @NotBlank(message = "Name is required!")
    @Length(min =2, max = 64, message = "Name is between 2 to 64 characters")
    private String name;

    @NotBlank(message = "Code is required!")
    @Length(min =2, max = 16, message = "Code is between 2 to 16 characters")
    private String code;

    private Long parentId;
    
    private String imagePath;
    private List<CategoryDto> children;
}
