package com.aquariux.cryptotrading.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aquariux.cryptotrading.domain.general.Asset;

public interface AssetRepository extends JpaRepository<Asset, String> {

}
