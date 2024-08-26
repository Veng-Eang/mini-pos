package com.vengeang.minipos.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name="exchage_rates")
@Data
@EqualsAndHashCode(callSuper = true)
public class ExchangeRate extends BaseEntity{
	@Column(nullable = false)
	private Double exchangeRate;
}
