package net.devcostin.code;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;

import net.devcostin.code.aplication.searchProductPrice.SearchProductPriceRequest;
import net.devcostin.code.aplication.searchProductPrice.SearchProductPriceResponse;
import net.devcostin.code.aplication.searchProductPrice.SearchProductPriceUseCase;
import net.devcostin.code.domain.models.Price;
import net.devcostin.code.domain.repositories.PriceRepository;
import net.devcostin.code.domain.services.PriceService;
import net.devcostin.code.domain.util.FormatUtil;


class ECommerceApplicationUnitaryTests {

	PriceRepository repository = Mockito.mock(PriceRepository.class);
	PriceService service = new PriceService(repository);
	SearchProductPriceUseCase useCase = new SearchProductPriceUseCase(service);

	@Test
	void shouldSearchProductPriceFirstCase() {
		// time:10:00 , day:14, product:35455, brand:1
		Mockito.when(repository.findAll()).thenReturn(getAllPrices());
		
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
		assertThat( FormatUtil.formatDateToString(response.getDate()), equalTo("2020-06-14-10.00.00"));
		assertThat(response.getFinalPrice(), equalTo("35,50EUR"));
	}

	@Test
	void shouldSearchProductPriceSecondCase() {
		// time:16:00 , day:14, product:35455, brand:1
		Mockito.when(repository.findAll()).thenReturn(getAllPrices());
		
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
		assertThat( FormatUtil.formatDateToString(response.getDate()), equalTo("2020-06-14-16.00.00"));
		assertThat(response.getFinalPrice(), equalTo("25,45EUR"));
	}

	private List<Price> getAllPrices() {
		
		return new ArrayList<>(Arrays.asList(

				Price.builder().brandId(1)
				.startDate(LocalDateTime.of(2020, 06, 14, 0, 0, 0))
				.endDate(LocalDateTime.of(2020, 12, 31, 23, 59, 59))
				.priceList(1).productId(35455).priority(0).price(35.50).currency("EUR").build(),

				Price.builder().brandId(1)
				.startDate(LocalDateTime.of(2020, 6, 14, 15, 0, 0))
				.endDate(LocalDateTime.of(2020, 6, 14, 18, 30, 0))
				.priceList(2).productId(35455).priority(1).price(25.45).currency("EUR").build(),

				Price.builder().brandId(1)
				.startDate(LocalDateTime.of(2020, 6, 15, 0, 0, 0))
				.endDate(LocalDateTime.of(2020, 6, 15, 11, 0, 0))
				.priceList(3).productId(35455).priority(1).price(30.50).currency("EUR").build(),

				Price.builder().brandId(1)
				.startDate(LocalDateTime.of(2020, 6, 15, 16, 0, 0))
				.endDate(LocalDateTime.of(2020, 12, 31, 23, 59, 59))
				.priceList(4).productId(35455).priority(1).price(25.45).currency("EUR").build()
				));
	}

}