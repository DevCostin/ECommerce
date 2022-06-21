package net.devcostin.code.aplication.searchProductPrice;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SearchProductPriceRequest{
	public LocalDateTime date;
	public int productId;
	public int brandId;
}