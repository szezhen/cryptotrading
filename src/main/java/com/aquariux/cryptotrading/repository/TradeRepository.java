package com.aquariux.cryptotrading.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.aquariux.cryptotrading.domain.account.Trade;

public interface TradeRepository extends JpaRepository<Trade, Long> {
	
}
