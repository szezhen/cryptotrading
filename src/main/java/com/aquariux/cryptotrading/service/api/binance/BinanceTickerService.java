package com.aquariux.cryptotrading.service.api.binance;

import java.util.List;

import com.aquariux.cryptotrading.service.dto.binance.BinanceTicker;

public interface BinanceTickerService {

	List<BinanceTicker> getTickers();
	
}