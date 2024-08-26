package com.vengeang.minipos.dto;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class GeneralSettingDto {
	private Long id;
	@NotBlank(message = "Site title is required..!")
	@Length(min = 2, max = 128, message = "Site title must be greater them 2 characters and less then 128 characters..!")
	private String siteTitle;
	@NotBlank(message = "Site logo  is required..!")
	@Length(min = 2, max = 128, message = "Site logo must be greater them 2 characters and less then 128 characters..!")
	private String siteLogo;
	@NotBlank(message = "Site phone  is required..!")
	@Length(min = 2, max = 32, message = "Site phone must be greater them 2 characters and less then 32 characters..!")
	private String sitePhone;
	@NotBlank(message = "Site address is required..!")
	@Length(min = 2, max = 128, message = "Site address must be greater them 2 characters and less then 128 characters..!")
	private String siteAddress;
}
