package com.vengeang.minipos.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vengeang.minipos.dto.ExchangeRateDto;
import com.vengeang.minipos.service.ExchangeRateCrudService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/exchange_rate")
public class ExchangeRateController {
	private final ExchangeRateCrudService exchangeRateCrudService;
	@PostMapping
	ResponseEntity<ExchangeRateDto> create(@RequestBody @Validated ExchangeRateDto exchangeRateDto){
		return ResponseEntity.ok(exchangeRateCrudService.save(exchangeRateDto));
	}
	@GetMapping("{id}")
	ResponseEntity<ExchangeRateDto> getById(@PathVariable Long id){
		return ResponseEntity.ok(exchangeRateCrudService.getById(id));
	}
	
	
	@PutMapping("{id}")
	ResponseEntity<ExchangeRateDto> updateById(@PathVariable Long id,@RequestBody @Validated ExchangeRateDto exchangeRateDto){
		return ResponseEntity.ok(exchangeRateCrudService.updateById(id, exchangeRateDto));
	}
	
	@DeleteMapping("{id}")
	ResponseEntity<String> deleteById(@PathVariable Long id){
		exchangeRateCrudService.softDeleteById(id);
		return ResponseEntity.ok("Move exchange rate with id : "+id+" to trash success.");
	}
}
