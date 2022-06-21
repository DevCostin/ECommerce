package net.devcostin.code.infrastructure.persistence;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.devcostin.code.domain.models.Price;
import net.devcostin.code.domain.repositories.PriceRepository;
import net.devcostin.code.domain.util.FormatUtil;

@Repository
public class PriceRepositoryAdapter implements PriceRepository{

	@Autowired
	private PriceRepositoryJPA priceRepositoryJPA;

	@Override
	public List<Price> findAll() {

		return priceRepositoryJPA.findAll()
				.stream().map(p -> { 
					return Price.builder()
							.brandId(p.brandId)
							.startDate(FormatUtil.formatStringToDate(p.startDate))
							.endDate(FormatUtil.formatStringToDate(p.endDate))
							.priceList(p.priceList)
							.productId(p.productId)
							.priority(p.priority)
							.price(p.price)
							.currency(p.currency)
							.build(); 
				}).collect(Collectors.toList());
	}
}