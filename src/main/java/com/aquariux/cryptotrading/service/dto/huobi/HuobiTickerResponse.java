package com.aquariux.cryptotrading.service.dto.huobi;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class HuobiTickerResponse {

	@JsonProperty(value = "data")
	List<HuobiTicker> tickers;
	
}
