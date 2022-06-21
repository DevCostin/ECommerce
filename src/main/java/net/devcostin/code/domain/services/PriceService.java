package net.devcostin.code.domain.services;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;

import net.devcostin.code.domain.models.Price;
import net.devcostin.code.domain.repositories.PriceRepository;

public class PriceService {

	public PriceRepository repository;

	public PriceService(PriceRepository repository) {
		this.repository = repository;
	}

	public Price searchPrice(LocalDateTime date, int productId, int brandId) {
		Optional<Price> price = repository.findAll().stream().filter(p -> {
			
			return date.isAfter(p.startDate) && 
					date.isBefore(p.endDate) && 
					productId == p.productId && 
					brandId == p.brandId;
			
		}).collect(Collectors.maxBy(Comparator.comparingInt(p -> p.getPriority())));
		
		return price.get();
	}
}