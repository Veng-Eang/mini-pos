package com.vengeang.minipos.mapper;

import org.mapstruct.Mapper;

import com.vengeang.minipos.dto.ExchangeRateDto;
import com.vengeang.minipos.entity.ExchangeRate;

@Mapper(componentModel = "spring")
public interface ExchangeRateMapper {
	ExchangeRateDto toExchangeRateDto(ExchangeRate exchangeRate);
	ExchangeRate toExchangeRate(ExchangeRateDto exchangeRateDto);
}
