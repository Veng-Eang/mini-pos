package com.vengeang.minipos.service.impl;

import org.springframework.stereotype.Service;

import com.vengeang.minipos.dto.ExchangeRateDto;
import com.vengeang.minipos.entity.ExchangeRate;
import com.vengeang.minipos.exception.ResourceNotFoundException;
import com.vengeang.minipos.mapper.ExchangeRateMapper;
import com.vengeang.minipos.repository.ExchangeRateRepository;
import com.vengeang.minipos.service.ExchangeRateCrudService;

@Service
public class ExchangeRateCrudServiceImpl implements ExchangeRateCrudService {
	private final ExchangeRateRepository exchangeRateRepository;
	private final ExchangeRateMapper exchangeRateMapper;
	
	public ExchangeRateCrudServiceImpl(ExchangeRateRepository exchangeRateRepository,ExchangeRateMapper exchangeRateMapper) {
		this.exchangeRateRepository = exchangeRateRepository;
		this.exchangeRateMapper = exchangeRateMapper;
	}

	@Override
	public ExchangeRateDto save(ExchangeRateDto data) {
		ExchangeRate exchangeRate = exchangeRateRepository.save(exchangeRateMapper.toExchangeRate(data));
		return exchangeRateMapper.toExchangeRateDto(exchangeRate);
	}

	@Override
	public ExchangeRateDto getById(Long id) {
		ExchangeRate exchangeRate = exchangeRateRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Exchange Rate", id));
		return exchangeRateMapper.toExchangeRateDto(exchangeRate);
	}

	@Override
	public ExchangeRateDto updateById(Long id, ExchangeRateDto dataUpdate) {
		ExchangeRate exchangeRate = exchangeRateRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Exchange Rate", id));
		exchangeRate.setExchangeRate(dataUpdate.getExchangeRate());
		exchangeRate = exchangeRateRepository.save(exchangeRate);
		return exchangeRateMapper.toExchangeRateDto(exchangeRate);
	}

	@Override
	public void deleteById(Long id) {
		ExchangeRate exchangeRate = exchangeRateRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Exchange Rate", id));
		exchangeRateRepository.delete(exchangeRate);
		System.out.println("deleted success");
	}

	@Override
	public ExchangeRateDto softDeleteById(Long id) {
		ExchangeRate exchangeRate = exchangeRateRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Exchange Rate", id));
		exchangeRate.setIsDeleted(true);
		exchangeRate = exchangeRateRepository.save(exchangeRate);
		return exchangeRateMapper.toExchangeRateDto(exchangeRate);
	}

}
