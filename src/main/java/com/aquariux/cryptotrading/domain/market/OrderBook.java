package com.aquariux.cryptotrading.domain.market;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

import com.aquariux.cryptotrading.domain.account.Order;

import lombok.Data;

@Data
public class OrderBook {

	private final String symbol;
	
	private Map<BigDecimal, List<Order>> bids = null;
	private Map<BigDecimal, List<Order>> asks = null;
	
	private Queue<BigDecimal> bestBidPrices = null;
	private Queue<BigDecimal> bestAskPrices = null;
	
	public OrderBook(String symbol) {
		this.symbol = symbol;
		
		bids = new HashMap<BigDecimal, List<Order>>();
		asks = new HashMap<BigDecimal, List<Order>>();
		
		// top is max bid price
		bestBidPrices = new PriorityQueue<BigDecimal>(30, Collections.reverseOrder());
		
		// top is min ask price
		bestAskPrices = new PriorityQueue<BigDecimal>();
	}
	
}
