package com.aquariux.cryptotrading.service.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserSpotAsset {
	
	private String asset;
	private BigDecimal free;
	private BigDecimal locked;
	
}
