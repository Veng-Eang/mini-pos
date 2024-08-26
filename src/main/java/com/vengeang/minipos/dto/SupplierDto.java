package com.vengeang.minipos.dto;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class SupplierDto {

	private Long id;
	@NotBlank(message = "Supplier local name  is required..!")
	@Length(min = 2, max = 128, message = "Supplier local name must be greater them 2 characters and less then 128 characters..!")
	private String supplierLocalName;
	@NotBlank(message = "Supplier english name  is required..!")
	@Length(min = 2, max = 128, message = "Supplier english name must be greater them 2 characters and less then 128 characters..!")
	private String supplierEngName;
	@NotBlank(message = "Supplier email is required..!")
	@Length(min = 2, max = 128, message = "Supplier email must be greater them 2 characters and less then 128 characters..!")
	@Email(message = "Email is invalid..!")
	private String supplierEmail;
	@NotBlank(message = "Supplier phone  is required..!")
	@Length(min = 2, max = 32, message = "Supplier phone must be greater them 2 characters and less then 32 characters..!")
	private String supplierPhone;
	@NotBlank(message = "Supplier address  is required..!")
	@Length(min = 2, max = 128, message = "Supplier address must be greater them 2 characters and less then 128 characters..!")
	private String supplierAddress;
	@NotBlank(message = "Supplier address is required..!")
	@Length(min = 2, max = 128, message = "Supplier address must be greater them 2 characters and less then 128 characters..!")
	private String vatNumber;
}
