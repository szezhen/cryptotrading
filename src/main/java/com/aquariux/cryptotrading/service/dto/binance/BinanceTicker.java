package com.aquariux.cryptotrading.service.dto.binance;

import java.util.Locale;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class BinanceTicker {

	private String symbol;
	
	@JsonProperty(value = "bidPrice")
	private String bidPrice;
	
	@JsonProperty(value = "bidQty")
	private String bidSize;
	
	@JsonProperty(value = "askPrice")
	private String askPrice;
	
	@JsonProperty(value = "askQty")
	private String askSize;
	
	public void setSymbol(String symbol) {
		this.symbol = StringUtils.upperCase(symbol, Locale.ENGLISH);
	}
	
}
