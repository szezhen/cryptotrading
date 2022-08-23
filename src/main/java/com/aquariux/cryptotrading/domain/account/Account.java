package com.aquariux.cryptotrading.domain.account;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.aquariux.cryptotrading.enumeration.AccountStatus;
import com.aquariux.cryptotrading.enumeration.AccountType;

import lombok.Data;

@Entity
@Table(name = "accounts")
@Data
public class Account implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "id")
	private String id;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "type")
	private AccountType type;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "status")
	private AccountStatus status;
	
	@CreatedDate
	@Column(name = "created_date", updatable = false)
	private Instant createdDate = Instant.now();
	
	@LastModifiedDate
	@Column(name = "last_modified_date")
	private Instant lastModifiedDate;
	
	@Column(name = "uid")
	private String uid;
}
