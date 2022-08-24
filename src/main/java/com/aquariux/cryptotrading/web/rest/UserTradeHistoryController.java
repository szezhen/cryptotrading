package com.aquariux.cryptotrading.web.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aquariux.cryptotrading.service.UserTradeService;
import com.aquariux.cryptotrading.service.dto.UserTradeHistory;

@RestController
@RequestMapping("/api")
public class UserTradeHistoryController {

	private final Logger log = LoggerFactory.getLogger(UserTradeHistoryController.class);

	private final UserTradeService userTradeService;
	
	public UserTradeHistoryController(UserTradeService userTradeService) {
		this.userTradeService = userTradeService;
	}

	@GetMapping("/users/spot/trades/history")
	public List<UserTradeHistory> getUserSpotTradeHistory() {
		log.debug("REST request to get all trade history");
		
		// TODO remove after implementation of authentication
		String uid = "b8032f4b-81e9-4816-9ff9-e47fbf8f32e0";
		
		return userTradeService.getUserSpotTradeHistory(uid);
	}
	
}
