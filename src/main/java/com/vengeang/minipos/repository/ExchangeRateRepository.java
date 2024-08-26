package com.vengeang.minipos.repository;

import org.springframework.stereotype.Repository;

import com.vengeang.minipos.entity.ExchangeRate;

@Repository
public interface ExchangeRateRepository extends GenericRepository<ExchangeRate, Long> {

}
