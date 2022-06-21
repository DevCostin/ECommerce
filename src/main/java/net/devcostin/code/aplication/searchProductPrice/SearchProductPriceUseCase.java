package net.devcostin.code.aplication.searchProductPrice;

import java.time.LocalDateTime;

public class SearchProductPriceUseCase {

	public SearchProductPriceResponse execute(SearchProductPriceRequest request) {

		SearchProductPriceResponse response = SearchProductPriceResponse.builder()
				.productId(35455)
				.brandId(1)
				.finalPrice("35.50EUR").build();

		if(request.getDate().getHour()==16) {
			response.price_list = 2;
			response.date = LocalDateTime.of(2020, 6, 14, 16, 0, 0);
			response.finalPrice = "25.45EUR";
		}else {
			response.price_list = 1;
			response.date = LocalDateTime.of(2020, 6, 14, 10, 0, 0);
			response.finalPrice = "35.50EUR";
		}

		return response; 
	}
}