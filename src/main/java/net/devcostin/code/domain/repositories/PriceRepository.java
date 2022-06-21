package net.devcostin.code.domain.repositories;

import java.util.List;

import net.devcostin.code.domain.models.Price;

public interface PriceRepository {
	public List<Price> findAll();
}