package net.devcostin.code;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


import org.junit.jupiter.api.Test;

import net.devcostin.code.aplication.searchProductPrice.SearchProductPriceRequest;
import net.devcostin.code.aplication.searchProductPrice.SearchProductPriceResponse;


class ECommerceApplicationUnitaryTests {

	@Test
	void shouldSearchProductPriceFirstCase() {
		// time:10:00 , day:14, product:35455, brand:1
		SearchProductPriceResponse response = SearchProductPriceResponse.builder().build();		
		
		assertThat(response.productId, equalTo(35455));
		assertThat(response.brandId, equalTo(1));
		assertThat(response.getPrice_list(), equalTo(1));
		assertThat(response.getDate().toString(), equalTo("2020-06-14-10.00.00"));
		assertThat(response.getFinalPrice(), equalTo("35.50EUR"));
	}
}