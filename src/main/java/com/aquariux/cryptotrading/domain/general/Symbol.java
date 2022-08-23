package com.aquariux.cryptotrading.domain.general;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.aquariux.cryptotrading.enumeration.SymbolStatus;

import lombok.Data;

@Entity
@Table(name = "symbols")
@Data
public class Symbol implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "symbol")
	private String symbol;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "status")
	private SymbolStatus status;
	
	@CreatedDate
	@Column(name = "created_date", updatable = false)
	private Instant createdDate = Instant.now();
	
	@LastModifiedDate
	@Column(name = "last_modified_date")
	private Instant lastModifiedDate;
}
