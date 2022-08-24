package com.aquariux.cryptotrading.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.aquariux.cryptotrading.domain.account.Trade;
import com.aquariux.cryptotrading.enumeration.AccountType;
import com.aquariux.cryptotrading.service.dto.UserTradeHistory;

public interface TradeRepository extends JpaRepository<Trade, Long> {

	@Query(value = "SELECT new com.aquariux.cryptotrading.service.dto.UserTradeHistory("
			+ "o.symbol, t.id, t.orderId, t.price, t.size, t.quoteSize, t.createdDate, t.lastModifiedDate) "
			+ "FROM Trade t "
			+ "INNER JOIN Order o ON o.id = t.orderId "
			+ "INNER JOIN Account a ON a.id = o.accId "
			+ "INNER JOIN User u ON u.id = a.uid "
			+ "WHERE u.id = :uid AND a.type = :#{#type}")
	List<UserTradeHistory> findAllByUserUidAndAccountType(String uid, AccountType type);
	
}
