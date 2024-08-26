package com.vengeang.minipos.dto;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CustomerDto {
	private Long id;
	@NotBlank(message = "Customer local name is required..!")
	@Length(min = 2, max = 128, message = "Customer local name must be greater them 2 characters and less then 128 characters..!")
    private String customerLocalName;
	@NotBlank(message = "Customer english name is required..!")
	@Length(min = 2, max = 128, message = "Customer english name must be greater them 2 characters and less then 128 characters..!")
    private String customerEngName;
	@NotBlank(message = "Customer Local Name is required..!")
	@Length(min = 2, max = 128, message = "Customer Local Name must be greater them 2 characters and less then 128 characters..!")
    @Email(message = "Email is invalid..!")
	private String customerEmail;
	@NotBlank(message = "Customer phone is required..!")
	@Length(min = 2, max = 32, message = "Customer phone must be greater them 2 characters and less then 32 characters..!")
    private String customerPhone;
	@NotBlank(message = "Customer address is required..!")
	@Length(min = 2, max = 128, message = "Customer address must be greater them 2 characters and less then 128 characters..!")
    private String customerAddress;
}
