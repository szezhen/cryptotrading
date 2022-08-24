package com.aquariux.cryptotrading.domain.market;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;

@Data
public class Market {

	private Map<String, OrderBook> orderBooks = new HashMap<String, OrderBook>();;
	
}
