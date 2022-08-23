package com.aquariux.cryptotrading.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.aquariux.cryptotrading.domain.account.AccountAsset;
import com.aquariux.cryptotrading.domain.account.AccountAssetId;
import com.aquariux.cryptotrading.enumeration.AccountType;
import com.aquariux.cryptotrading.service.dto.UserSpotAsset;

public interface AccountAssetRepository extends JpaRepository<AccountAsset, AccountAssetId> {

	@Query(value = "SELECT new com.aquariux.cryptotrading.service.dto.UserSpotAsset(at.assetCode AS asset, aa.free, aa.locked) "
			+ "FROM Asset at "
			+ "INNER JOIN AccountAsset aa ON aa.assetId = at.id "
			+ "INNER JOIN Account a ON a.id = aa.accId "
			+ "INNER JOIN User u ON u.id = a.uid "
			+ "WHERE u.id = :uid AND a.type = :type")
	List<UserSpotAsset> findAllByUserUidAndAccountType(String uid, AccountType type);

}
