package net.devcostin.code.aplication.searchProductPrice;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SearchProductPriceResponse{
	public int productId;
	public int brandId;
	public int price_list;
	public LocalDateTime date;
	public String finalPrice;
}