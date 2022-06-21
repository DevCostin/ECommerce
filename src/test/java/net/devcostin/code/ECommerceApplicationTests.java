package net.devcostin.code;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import net.devcostin.code.aplication.searchProductPrice.SearchProductPriceRequest;
import net.devcostin.code.aplication.searchProductPrice.SearchProductPriceResponse;
import net.devcostin.code.aplication.searchProductPrice.SearchProductPriceUseCase;
import net.devcostin.code.domain.util.FormatDate;


class ECommerceApplicationUnitaryTests {

	@Test
	void shouldSearchProductPriceFirstCase() {
		// time:10:00 , day:14, product:35455, brand:1
		SearchProductPriceUseCase useCase = new SearchProductPriceUseCase();
		SearchProductPriceResponse response = useCase.execute(
				SearchProductPriceRequest.builder()
				.date(LocalDateTime.of(2020, 6, 14, 10, 0, 0))
				.productId(35455)
				.brandId(1)
				.build()
				);		
		
		assertThat(response.productId, equalTo(35455));
		assertThat(response.brandId, equalTo(1));
		assertThat(response.getPrice_list(), equalTo(1));
		assertThat( FormatDate.formatDateToString(response.getDate()), equalTo("2020-06-14-10.00.00"));
		assertThat(response.getFinalPrice(), equalTo("35.50EUR"));
	}
	
	@Test
	void shouldSearchProductPriceSecondCase() {
		// time:16:00 , day:14, product:35455, brand:1
		SearchProductPriceUseCase useCase = new SearchProductPriceUseCase();
		SearchProductPriceResponse response = useCase.execute(
				SearchProductPriceRequest.builder()
				.date(LocalDateTime.of(2020, 6, 14, 16, 0, 0))
				.productId(35455)
				.brandId(1)
				.build()
				);		
		
		assertThat(response.productId, equalTo(35455));
		assertThat(response.brandId, equalTo(1));
		assertThat(response.getPrice_list(), equalTo(2));
		assertThat( FormatDate.formatDateToString(response.getDate()), equalTo("2020-06-14-16.00.00"));
		assertThat(response.getFinalPrice(), equalTo("25.45EUR"));
	}
}