package net.devcostin.code;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import net.devcostin.code.aplication.searchProductPrice.SearchProductPriceResponse;
import net.devcostin.code.domain.util.FormatUtil;

@SpringBootTest
class ECommerceApplicationIntegrationTests {

	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	public void shouldWork() {
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", "application/json");

		HttpEntity<String> entity = new HttpEntity<String>(headers);
		
		ResponseEntity<SearchProductPriceResponse> response =  restTemplate.exchange("/price?date=2020-06-14-10.00.00&productId=14&brandId=1", HttpMethod.GET, entity, SearchProductPriceResponse.class);
		
		assertThat(response.getBody().productId, equalTo(35455));
		assertThat(response.getBody().brandId, equalTo(1));
		assertThat(response.getBody().getPrice_list(), equalTo(1));
		assertThat( FormatUtil.formatDateToString(response.getBody().getDate()), equalTo("2020-06-14-10.00.00"));
		assertThat(response.getBody().getFinalPrice(), equalTo("35,50EUR"));
	}
}