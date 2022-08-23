package com.aquariux.cryptotrading.service.api.huobi;

import java.util.List;

import com.aquariux.cryptotrading.service.dto.huobi.HuobiTicker;

public interface HuobiTickerService {

	List<HuobiTicker> getTickers();
	
}
