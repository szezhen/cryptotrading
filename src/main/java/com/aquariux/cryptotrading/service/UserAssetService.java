package com.aquariux.cryptotrading.service;

import java.util.List;

import com.aquariux.cryptotrading.service.dto.UserSpotAsset;

public interface UserAssetService {

	List<UserSpotAsset> getUserSpotAssets(String uid);
	
}
