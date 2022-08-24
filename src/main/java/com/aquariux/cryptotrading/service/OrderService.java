package com.aquariux.cryptotrading.service;

import java.util.List;

import com.aquariux.cryptotrading.domain.account.Order;
import com.aquariux.cryptotrading.domain.account.Ticker;

public interface OrderService {

	Order save(Order newOrder);

	List<Ticker> getLatestTickers();
	
}
