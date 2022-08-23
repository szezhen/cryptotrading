package com.aquariux.cryptotrading.service;

import org.springframework.stereotype.Service;

import com.aquariux.cryptotrading.domain.account.Order;
import com.aquariux.cryptotrading.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

	private final OrderRepository orderRepository;
	
	public OrderServiceImpl(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}

	@Override
	public Order save(Order newOrder) {
		return orderRepository.save(newOrder);
	}

}
