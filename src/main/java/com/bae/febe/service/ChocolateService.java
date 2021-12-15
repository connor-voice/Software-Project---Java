package com.bae.febe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bae.febe.domain.Chocolate;
import com.bae.febe.repo.ChocolateRepo;

@Service
public class ChocolateService {

	private ChocolateRepo repo;

	@Autowired
	public ChocolateService(ChocolateRepo repo) {
		super();
		this.repo = repo;
	}

	public Chocolate createChocolate(Chocolate chocolate) {
		Chocolate create = this.repo.save(chocolate);
		return create;
	}

	public List<Chocolate> getAllChocolates() {
		return this.repo.findAll();
	}

	public Chocolate getChocolate(Integer id) {
		return this.repo.findById(id).get();
	}

	public Chocolate replaceChocolate(Integer id, Chocolate newChocolate) {
		Chocolate exists = this.repo.findById(id).get();

		exists.setName(newChocolate.getName());
		exists.setBrand(newChocolate.getBrand());
		exists.setPrice(newChocolate.getPrice());
		exists.setSize(newChocolate.getSize());
		exists.setQuantity(newChocolate.getQuantity());

		return this.repo.save(exists);

	}

	public Chocolate replaceChocolateQuantity(Integer id, Chocolate newChocolate) {
		Chocolate exists = this.repo.findById(id).get();

		exists.setQuantity(newChocolate.getQuantity());
		return this.repo.findById(id).get();
	}

	public void removeChocolate(Integer id) {
		this.repo.deleteById(id);
		System.out.println("Deleted chocolate with ID: " + id);
	}
}
