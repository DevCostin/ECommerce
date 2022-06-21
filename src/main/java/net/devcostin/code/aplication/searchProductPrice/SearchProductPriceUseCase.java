package net.devcostin.code.aplication.searchProductPrice;

import java.time.LocalDateTime;

public class SearchProductPriceUseCase {

	public SearchProductPriceResponse execute(SearchProductPriceRequest request) {

		return SearchProductPriceResponse.builder()
				.productId(35455)
				.brandId(1)
				.price_list(1)
				.date(LocalDateTime.of(2020, 6, 14, 10, 0, 0))
				.finalPrice("35.50EUR").build();
		
	}
}
