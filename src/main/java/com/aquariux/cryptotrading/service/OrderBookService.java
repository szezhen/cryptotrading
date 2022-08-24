package com.aquariux.cryptotrading.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.aquariux.cryptotrading.domain.account.Order;
import com.aquariux.cryptotrading.domain.market.OrderBook;

public interface OrderBookService {

	void addBid(OrderBook orderBook, BigDecimal price, BigDecimal size);
	void addAsk(OrderBook orderBook,BigDecimal price, BigDecimal size);
	List<Order> getBucket(Map<BigDecimal, List<Order>> map, BigDecimal price);
	void matchOrders(OrderBook orderBook);
	
}
