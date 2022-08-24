package com.aquariux.cryptotrading.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aquariux.cryptotrading.dao.OrderDao;
import com.aquariux.cryptotrading.domain.account.Order;
import com.aquariux.cryptotrading.domain.account.Ticker;
import com.aquariux.cryptotrading.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

	private final OrderRepository orderRepository;
	private final OrderDao orderDao;
	
	public OrderServiceImpl(
			OrderRepository orderRepository,
			OrderDao orderDao) {
		this.orderRepository = orderRepository;
		this.orderDao = orderDao;
	}

	@Override
	public Order save(Order newOrder) {
		return orderRepository.save(newOrder);
	}

	@Override
	public List<Ticker> getLatestTickers() {
		return orderDao.findLatestTickers();
	}

}
