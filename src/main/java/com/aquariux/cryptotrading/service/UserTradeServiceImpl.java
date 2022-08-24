package com.aquariux.cryptotrading.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aquariux.cryptotrading.enumeration.AccountType;
import com.aquariux.cryptotrading.repository.TradeRepository;
import com.aquariux.cryptotrading.service.dto.UserTradeHistory;

@Service
public class UserTradeServiceImpl implements UserTradeService {

	private final TradeRepository tradeRepository;

	public UserTradeServiceImpl(TradeRepository tradeRepository) {
		this.tradeRepository = tradeRepository;
	}

	@Override
	public List<UserTradeHistory> getUserSpotTradeHistory(String uid) {
		return tradeRepository.findAllByUserUidAndAccountType(uid, AccountType.SPOT);
	}
	
}
