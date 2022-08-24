package com.aquariux.cryptotrading.service.dto;

import java.math.BigDecimal;
import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserTradeHistory {

	private String symbol;
	private Long id;
	private Long orderId;
	private BigDecimal price;
	private BigDecimal size;
	private BigDecimal quoteSize;
	private Instant createdDate;
	private Instant lastModifiedDate;
	
}
