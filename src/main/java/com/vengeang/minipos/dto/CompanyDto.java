package com.vengeang.minipos.dto;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CompanyDto {
	private Long id;
	@NotBlank(message = "Company Local Name is required..!")
	@Length(min = 2, max = 128, message = "Company local name must be greater then 2 characters and less then 128 characters..!")
    private String companyLocalName;
	@NotBlank(message = "Company english name is required..!")
	@Length(min = 2, max = 128, message = "Company englist name must be greater then 2 characters and less then 128 characters..!")
    private String companyEngName;
	@NotBlank(message = "Company Local Name is required..!")
	@Length(min = 2, max = 128, message = "Company Local Name must be greater then 2 characters and less then 128 characters!..")
    @Email(message = "Email is invalid..!")
	private String companyEmail;
	@NotBlank(message = "Company Phone is required..!")
	@Length(min = 2, max = 32, message = "Company phone must be greater then 2 characters and less then 32 characters!")
    private String companyPhone;

	@NotBlank(message = "Company Address is required..!")
	@Length(min = 2, max = 128, message = "Company address must be greater them 2 characters and less then 128 characters!")
    private String companyAddress;
	@NotBlank(message = "VAT number is required..!")
	@Length(min = 2, max = 128, message = "VAT number must be greater them 2 characters and less then 128 characters!")
    private String vatNumber;

    private String imagePath;

    private String image;
}
