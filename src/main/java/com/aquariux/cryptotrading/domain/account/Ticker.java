package com.aquariux.cryptotrading.domain.account;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ticker {
	
	private String symbol;
	private BigDecimal bidPrice;
	private BigDecimal bidSize;
	private BigDecimal askPrice;
	private BigDecimal askSize;
	
}
