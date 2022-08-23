package com.aquariux.cryptotrading.service.dto.huobi;

import java.util.Locale;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class HuobiTicker {

	private String symbol;
	
	@JsonProperty(value = "bid")
	private float bidPrice;
	
	@JsonProperty(value = "bidSize")
	private float bidSize;
	
	@JsonProperty(value = "ask")
	private float askPrice;
	
	@JsonProperty(value = "askSize")
	private float askSize;
	
	public void setSymbol(String symbol) {
		this.symbol = StringUtils.upperCase(symbol, Locale.ENGLISH);
	}
	
}
