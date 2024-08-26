package com.vengeang.minipos.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "suppliers")
@Data
@EqualsAndHashCode(callSuper = true)
public class Supplier extends BaseEntity {
	@Column(nullable = false, length = 128)
    private String supplierLocalName;
	@Column(nullable = false, length = 128)
    private String supplierEngName;
	@Column(nullable = false, length = 128)
    private String supplierEmail;
	@Column(nullable = false, length = 32)
    private String supplierPhone;
	@Column(nullable = false, length = 128)
    private String supplierAddress;
	@Column(nullable = false, length = 128)
    private String vatNumber;
}
