package net.devcostin.code.aplication.searchProductPrice;

import org.springframework.stereotype.Service;

import net.devcostin.code.domain.models.Price;
import net.devcostin.code.domain.services.PriceService;

@Service
public class SearchProductPriceUseCase {

	public PriceService service;
	
	public SearchProductPriceUseCase(PriceService service) {
		this.service = service;
	}
	
	public SearchProductPriceResponse execute(SearchProductPriceRequest request) {
		
		Price price = service.searchPrice(request.date, request.productId, request.brandId);
		
		SearchProductPriceResponse response = SearchProductPriceResponse.builder()
				.productId(price.productId)
				.brandId(price.brandId)
				.price_list(price.priceList)
				.date(request.date)
				.finalPrice(price.getTotalPrice()).build();

		return response;
	}
}