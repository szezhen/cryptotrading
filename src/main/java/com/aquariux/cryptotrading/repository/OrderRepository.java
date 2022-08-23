package com.aquariux.cryptotrading.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.aquariux.cryptotrading.domain.account.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
	
}
