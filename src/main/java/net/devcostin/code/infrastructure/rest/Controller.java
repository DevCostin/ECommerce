package net.devcostin.code.infrastructure.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import net.devcostin.code.aplication.searchProductPrice.SearchProductPriceRequest;
import net.devcostin.code.aplication.searchProductPrice.SearchProductPriceResponse;
import net.devcostin.code.aplication.searchProductPrice.SearchProductPriceUseCase;
import net.devcostin.code.domain.util.FormatUtil;

@RestController
public class Controller {

	@Autowired
	private SearchProductPriceUseCase priceUseCase;

	@RequestMapping(path = "/prices", params = {"date","productId","brandId"}, method = RequestMethod.GET)
	@ResponseStatus(code = HttpStatus.OK)
	public SearchProductPriceResponse getPrice(@RequestParam("date") String date, @RequestParam("productId") int productId, @RequestParam("brandId") int brandId) {

		SearchProductPriceResponse response = priceUseCase.execute(
				SearchProductPriceRequest.builder()
				.date(FormatUtil.formatStringToDate(date))
				.productId(productId).brandId(brandId).build()
				);

		return response;
	}
}