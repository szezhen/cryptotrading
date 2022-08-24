package com.aquariux.cryptotrading.dao;

import java.util.List;

import com.aquariux.cryptotrading.domain.account.Ticker;

public interface OrderDao {
	
	List<Ticker> findLatestTickers();
	
}
