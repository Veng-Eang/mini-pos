package com.vengeang.minipos.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name="customers")
@Data
@EqualsAndHashCode(callSuper = true)
public class Customer extends BaseEntity {
	@Column(nullable = false, length = 128)
    private String customerLocalName;
	@Column(nullable = false, length = 128)
    private String customerEngName;
	@Column(nullable = false, length = 128)
    private String customerEmail;
	@Column(nullable = false, length = 32)
    private String customerPhone;
	@Column(nullable = false, length = 128)
    private String customerAddress;
}
