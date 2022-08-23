package com.aquariux.cryptotrading.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aquariux.cryptotrading.enumeration.AccountType;
import com.aquariux.cryptotrading.repository.AccountAssetRepository;
import com.aquariux.cryptotrading.service.dto.UserSpotAsset;

@Service
public class UserAssetServiceImpl implements UserAssetService {

	private final AccountAssetRepository accountAssetRepository;
	
	public UserAssetServiceImpl(AccountAssetRepository accountAssetRepository) {
		this.accountAssetRepository = accountAssetRepository;
	}

	@Override
	public List<UserSpotAsset> getUserSpotAssets(String uid) {
		return accountAssetRepository.findAllByUserUidAndAccountType(uid, AccountType.SPOT);
	}

}
