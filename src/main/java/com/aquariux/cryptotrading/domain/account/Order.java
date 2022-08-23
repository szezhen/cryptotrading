package com.aquariux.cryptotrading.domain.account;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.aquariux.cryptotrading.enumeration.OrderSide;
import com.aquariux.cryptotrading.enumeration.OrderStatus;
import com.aquariux.cryptotrading.enumeration.OrderType;

import lombok.Data;

@Entity
@Table(name = "orders")
@Data
public class Order implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "symbol")
	private String symbol;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "type")
	private OrderType type;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "side")
	private OrderSide side;
	
	@Column(name = "price")
	private BigDecimal price;
	
	@Column(name = "size")
	private BigDecimal size;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "status")
	private OrderStatus status;
	
	@CreatedDate
	@Column(name = "created_date", updatable = false)
	private Instant createdDate = Instant.now();
	
	@LastModifiedDate
	@Column(name = "last_modified_date")
	private Instant lastModifiedDate;
}
