package com.bae.febe.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bae.febe.domain.Chocolate;

@Repository
public interface ChocolateRepo extends JpaRepository<Chocolate, Integer> {

	List<Chocolate> findByName(String name);

	List<Chocolate> findByBrand(String brand);

	List<Chocolate> findByPrice(Double price);

	List<Chocolate> findBySize(Integer size);

}
