package com.aquariux.cryptotrading.service;

import java.util.List;

import com.aquariux.cryptotrading.service.dto.UserTradeHistory;

public interface UserTradeService {

	List<UserTradeHistory> getUserSpotTradeHistory(String uid);

}
