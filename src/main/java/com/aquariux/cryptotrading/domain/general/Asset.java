package com.aquariux.cryptotrading.domain.general;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.Data;

@Entity
@Table(name = "assets")
@Data
public class Asset implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "id")
	private String id;
	
	@Column(name = "asset_code")
	private String assetCode;
	
	@Column(name = "asset_name")
	private String assetName;
	
	@Column(name = "active")
	private boolean active;
	
	@CreatedDate
	@Column(name = "created_date", updatable = false)
	private Instant createdDate = Instant.now();
	
	@LastModifiedDate
	@Column(name = "last_modified_date")
	private Instant lastModifiedDate;
}
