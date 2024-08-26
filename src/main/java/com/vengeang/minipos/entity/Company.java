package com.vengeang.minipos.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name="companies")
@Data
@EqualsAndHashCode(callSuper = true)
public class Company extends BaseEntity {

	@Column(nullable = false, length = 128)
    private String companyLocalName;
	@Column(nullable = false, length = 128)
    private String companyEngName;
	@Column(nullable = false)
    private String companyEmail;

	@Column(nullable = false, length = 32)
    private String companyPhone;

	@Column(nullable = false, length = 128)
    private String companyAddress;

	@Column(nullable = false, length = 128)
    private String vatNumber;

    private String imagePath;

    private String image;
}
