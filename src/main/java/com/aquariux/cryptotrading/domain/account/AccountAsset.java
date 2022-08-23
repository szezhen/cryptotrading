package com.aquariux.cryptotrading.domain.account;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "account_assets")
@IdClass(AccountAssetId.class)
@Data
@NoArgsConstructor
public class AccountAsset implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "acc_id", nullable = false)
	private String accId;
	
	@Id
	@Column(name = "asset_id", nullable = false)
	private String assetId;

	@Column(name = "free")
	private BigDecimal free;
	
	@Column(name = "locked")
	private BigDecimal locked;
	
	@CreatedDate
	@Column(name = "created_date", updatable = false)
	private Instant createdDate = Instant.now();
	
	@LastModifiedDate
	@Column(name = "last_modified_date")
	private Instant lastModifiedDate;
}
