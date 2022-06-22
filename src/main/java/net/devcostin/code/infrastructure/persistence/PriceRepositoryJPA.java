package net.devcostin.code.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.devcostin.code.infrastructure.persistence.entities.PriceEntity;

@Repository
public interface PriceRepositoryJPA extends JpaRepository<PriceEntity, Long>{

}
