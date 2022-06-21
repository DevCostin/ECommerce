package net.devcostin.code.infrastructure.persistence.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "PRICES")
public class PriceEntity {
	
	@Id
	@Column(name = "PRICE_ID")
	public Long priceId;
	
	@Column(name = "BRAND_ID")
	public int brandId;
	@Column(name = "START_DATE")
	public String startDate;
	@Column(name = "END_DATE")
	public String endDate;
	@Column(name = "PRICE_LIST")
	public int priceList;
	@Column(name = "PRODUCT_ID")
	public int productId;
	@Column(name = "PRIORITY")
	public int priority;
	@Column(name = "PRICE")
	public double price;
	@Column(name = "CURRENCY")
	public String currency;	
}