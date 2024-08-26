package com.vengeang.minipos.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ExchangeRateDto {
	private Long id;
	@NotNull(message = "Exchange Rate is required!")
	private Double exchangeRate;
}
