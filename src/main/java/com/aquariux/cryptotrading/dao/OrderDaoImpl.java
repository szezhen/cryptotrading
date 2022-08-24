package com.aquariux.cryptotrading.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Tuple;

import org.springframework.stereotype.Repository;

import com.aquariux.cryptotrading.domain.account.Ticker;

@Repository
public class OrderDaoImpl implements OrderDao {

	@PersistenceContext(unitName = "cryptotrading")
	private EntityManager em;
	
	@Override
	public List<Ticker> findLatestTickers() {
		StringBuilder sql = new StringBuilder("SELECT r1.symbol, r1.bid_price, r1.bid_size, r2.ask_price, r2.ask_size FROM "
			+ "(SELECT t1.symbol, t1.bid_price, SUM(o1.size) AS bid_size FROM "
				+ "( SELECT symbol, MAX(price) AS bid_price FROM ORDERS WHERE side='BUY' AND (status = 'OPEN' OR status = 'PARTIALLY_FILLED') "
				+ "GROUP BY symbol "
				+ ") t1 "
			+ "INNER JOIN ORDERS o1 ON o1.symbol = t1.symbol AND o1.price = t1.bid_price "
			+ "WHERE o1.side='BUY' AND (o1.status = 'OPEN' OR o1.status = 'PARTIALLY_FILLED') "
			+ "GROUP BY t1.symbol, t1.bid_price) r1 "
			+ "INNER JOIN "
			+ "(SELECT t2.symbol, t2.ask_price, SUM(o2.size) AS ask_size FROM "
				+ "(SELECT symbol, MIN(price) AS ask_price FROM ORDERS WHERE side='SELL' AND (status = 'OPEN' OR status = 'PARTIALLY_FILLED') "
				+ "GROUP BY symbol "
				+ ") t2 "
			+ "INNER JOIN ORDERS o2 ON o2.symbol = t2.symbol AND o2.price = t2.ask_price "
			+ "WHERE o2.side='SELL' AND (o2.status = 'OPEN' OR o2.status = 'PARTIALLY_FILLED') "
			+ "GROUP BY t2.symbol, t2.ask_price) r2 "
			+ "ON r2.symbol = r1.symbol");
		
		List<Tuple> tuples = em.createNativeQuery(sql.toString(), Tuple.class)
				.getResultList();
		
		tuples.stream().forEach(System.out::println);
		
		return null;
	}

}
