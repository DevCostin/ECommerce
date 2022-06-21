package net.devcostin.code.domain.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import net.devcostin.code.domain.models.Price;

public interface PriceRepository {
	public List<Price> findAll();
}