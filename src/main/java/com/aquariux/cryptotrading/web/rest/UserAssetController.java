package com.aquariux.cryptotrading.web.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aquariux.cryptotrading.service.UserAssetService;
import com.aquariux.cryptotrading.service.dto.UserSpotAsset;

@RestController
@RequestMapping("/api")
public class UserAssetController {
	
	private final Logger log = LoggerFactory.getLogger(UserAssetController.class);
	
	private final UserAssetService userAssetService;
	
	public UserAssetController(UserAssetService userAssetService) {
		this.userAssetService = userAssetService;
	}

	@GetMapping("/users/spot/assets")
	public List<UserSpotAsset> getUserSpotAssets() {
		log.debug("REST request to get user assets");
		
		// TODO remove after implementation of authentication
		String uid = "b8032f4b-81e9-4816-9ff9-e47fbf8f32e0";
		
		return userAssetService.getUserSpotAssets(uid);
	}
	
}
