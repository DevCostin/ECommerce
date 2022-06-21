package net.devcostin.code;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import net.devcostin.code.aplication.searchProductPrice.SearchProductPriceResponse;
import net.devcostin.code.domain.util.FormatUtil;

@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
class ECommerceApplicationIntegrationTests {

	@Autowired
	public TestRestTemplate restTemplate;
	
	@Test
	public void shouldWork() {		
		
		ResponseEntity<SearchProductPriceResponse> response =  restTemplate.getForEntity("/prices?date=2020-06-14-10.00.00&productId=35455&brandId=1", SearchProductPriceResponse.class);
		
		assertThat(response.getBody().productId, equalTo(35455));
		assertThat(response.getBody().brandId, equalTo(1));
		assertThat(response.getBody().getPrice_list(), equalTo(1));
		assertThat( FormatUtil.formatDateToString(response.getBody().getDate()), equalTo("2020-06-14-10.00.00"));
		assertThat(response.getBody().getFinalPrice(), equalTo("35,50EUR"));
		
		assertTrue(response.getStatusCode().is2xxSuccessful());
	}
}