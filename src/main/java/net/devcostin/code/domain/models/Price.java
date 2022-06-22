package net.devcostin.code.domain.models;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;
import net.devcostin.code.domain.util.FormatUtil;

@Data
@Builder
public class Price {
	public int brandId;
	public LocalDateTime startDate;
	public LocalDateTime endDate;
	public int priceList;
	public int productId;
	public int priority;
	public double price;
	public String currency;	
	
	public String getTotalPrice() {
		return FormatUtil.doubleToStringTwoDecimals(price)+currency;
	}
}