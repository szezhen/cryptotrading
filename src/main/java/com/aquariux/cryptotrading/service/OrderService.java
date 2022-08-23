package com.aquariux.cryptotrading.service;

import com.aquariux.cryptotrading.domain.account.Order;

public interface OrderService {

	Order save(Order newOrder);
	
}
