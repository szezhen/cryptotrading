package com.aquariux.cryptotrading.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.aquariux.cryptotrading.domain.account.Order;
import com.aquariux.cryptotrading.domain.account.Ticker;

public interface OrderRepository extends JpaRepository<Order, Long> {

//	@Query(value = "SELECT r1.symbol, r1.bid_price, r1.bid_size, r2.ask_price, r2.ask_size FROM "
//			+ "(SELECT t1.symbol, t1.bid_price, SUM(o1.size) AS bid_size FROM "
//				+ "( SELECT symbol, MAX(price) AS bid_price FROM ORDERS WHERE side='BUY' AND (status = 'OPEN' OR status = 'PARTIALLY_FILLED') "
//				+ "GROUP BY symbol "
//				+ ") t1 "
//			+ "INNER JOIN ORDERS o1 ON o1.symbol = t1.symbol AND o1.price = t1.bid_price "
//			+ "WHERE o1.side='BUY' AND (o1.status = 'OPEN' OR o1.status = 'PARTIALLY_FILLED') "
//			+ "GROUP BY t1.symbol, t1.bid_price) r1 "
//			+ "INNER JOIN "
//			+ "(SELECT t2.symbol, t2.ask_price, SUM(o2.size) AS ask_size FROM "
//				+ "(SELECT symbol, MIN(price) AS ask_price FROM ORDERS WHERE side='SELL' AND (status = 'OPEN' OR status = 'PARTIALLY_FILLED') "
//				+ "GROUP BY symbol "
//				+ ") t2 "
//			+ "INNER JOIN ORDERS o2 ON o2.symbol = t2.symbol AND o2.price = t2.ask_price "
//			+ "WHERE o2.side='SELL' AND (o2.status = 'OPEN' OR o2.status = 'PARTIALLY_FILLED') "
//			+ "GROUP BY t2.symbol, t2.ask_price) r2 "
//			+ "ON r2.symbol = r1.symbol",
//		nativeQuery = true)
//	List<Ticker> findLatestTickers();
	
//	@Query(value = "SELECT new Ticker(r1.symbol, r1.bidPrice, r1.bidSize, r2.askPrice, r2.askSize) FROM "
//			+ "(SELECT t1.symbol, t1.bidPrice, SUM(o1.size) AS bidSize FROM "
//				+ "( SELECT symbol, MAX(price) AS bidPrice FROM Order WHERE side='BUY' AND (status = 'OPEN' OR status = 'PARTIALLY_FILLED') "
//				+ "GROUP BY symbol "
//				+ ") t1 "
//			+ "INNER JOIN Order o1 ON o1.symbol = t1.symbol AND o1.price = t1.bidPrice "
//			+ "WHERE o1.side='BUY' AND (o1.status = 'OPEN' OR o1.status = 'PARTIALLY_FILLED') "
//			+ "GROUP BY t1.symbol, t1.bidPrice) r1 "
//			+ "INNER JOIN "
//			+ "(SELECT t2.symbol, t2.askPrice, SUM(o2.size) AS askSize FROM "
//				+ "(SELECT symbol, MIN(price) AS askPrice FROM Order WHERE side='SELL' AND (status = 'OPEN' OR status = 'PARTIALLY_FILLED') "
//				+ "GROUP BY symbol "
//				+ ") t2 "
//			+ "INNER JOIN Order o2 ON o2.symbol = t2.symbol AND o2.price = t2.askPrice "
//			+ "WHERE o2.side='SELL' AND (o2.status = 'OPEN' OR o2.status = 'PARTIALLY_FILLED') "
//			+ "GROUP BY t2.symbol, t2.askPrice) r2 "
//			+ "ON r2.symbol = r1.symbol")
//	List<Ticker> findLatestTickers();
	
}
