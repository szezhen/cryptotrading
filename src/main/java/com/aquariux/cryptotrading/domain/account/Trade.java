package com.aquariux.cryptotrading.domain.account;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.Data;

@Entity
@Table(name = "trades")
@Data
public class Trade implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "order_id")
	private Long orderId;
	
	@Column(name = "price")
	private BigDecimal price;
	
	@Column(name = "size")
	private BigDecimal size;
	
	@Column(name = "quoteSize")
	private BigDecimal quoteSize;
	
	@CreatedDate
	@Column(name = "created_date")
	private Instant createdDate = Instant.now();
	
	@LastModifiedDate
	@Column(name = "last_modified_date")
	private Instant lastModifiedDate;
	
	public BigDecimal getQuoteSize() {
		return this.price.multiply(this.size);
	}
	
}
