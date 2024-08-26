package com.vengeang.minipos.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "general_settings")
@Data
@EqualsAndHashCode(callSuper = true)
public class GeneralSetting extends BaseEntity {
	@Column(nullable = false, length = 128)
	private String siteTitle;
	@Column(nullable = false)
	private String siteLogo;

	@Column(nullable = false, length = 32)
	private String sitePhone;
	@Column(nullable = false, length = 128)
	private String siteAddress;
}
