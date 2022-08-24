package com.aquariux.cryptotrading.web.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aquariux.cryptotrading.domain.account.Ticker;
import com.aquariux.cryptotrading.service.OrderService;

@RestController
@RequestMapping("/api")
public class TickerController {

	private final Logger log = LoggerFactory.getLogger(TickerController.class);
	
	private final OrderService orderService;
	
	public TickerController(OrderService orderService) {
		this.orderService = orderService;
	}

	@GetMapping("/tickers")
	public List<Ticker> getLatestTickers() {
		log.debug("REST reqeust to get latest tickers");
		
		return orderService.getLatestTickers();
	}
	
}
