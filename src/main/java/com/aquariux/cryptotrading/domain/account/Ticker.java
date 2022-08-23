package com.aquariux.cryptotrading.domain.account;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class Ticker {
	
	private String symbol;
	private BigDecimal bidPrice;
	private BigDecimal bidSize;
	private BigDecimal askPrice;
	private BigDecimal askSize;
	
}
