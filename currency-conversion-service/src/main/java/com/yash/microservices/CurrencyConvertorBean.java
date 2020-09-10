package com.yash.microservices;

import java.math.BigDecimal;

public class CurrencyConvertorBean {
	
	private Long id;
	private String from;
	private String to;
	private BigDecimal conversionMultiple;
	private int port;
	private BigDecimal totalCalculatedAmount;
	private BigDecimal quantity;
	public CurrencyConvertorBean(Long id, String from, String to, BigDecimal conversionMultiple,
			BigDecimal totalCalculatedAmount, BigDecimal quantity,int port) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionMultiple = conversionMultiple;
		this.totalCalculatedAmount = totalCalculatedAmount;
		this.quantity = quantity;
		this.port = port;
	}
	
	public CurrencyConvertorBean() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public BigDecimal getConversionMultiple() {
		return conversionMultiple;
	}

	public void setConversionMultiple(BigDecimal conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public BigDecimal getTotalCalculatedAmount() {
		return totalCalculatedAmount;
	}

	public void setTotalCalculatedAmount(BigDecimal totalCalculatedAmount) {
		this.totalCalculatedAmount = totalCalculatedAmount;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}
}
