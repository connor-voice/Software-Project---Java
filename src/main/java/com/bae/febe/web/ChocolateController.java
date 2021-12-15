package com.bae.febe.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bae.febe.domain.Chocolate;
import com.bae.febe.service.ChocolateService;

@CrossOrigin
@RestController
public class ChocolateController {

	private ChocolateService chocserv;

	@Autowired
	public ChocolateController(ChocolateService chocserv) {
		super();
		this.chocserv = chocserv;
	}

	@PostMapping("/create")
	public ResponseEntity<Chocolate> createChocolate(@RequestBody Chocolate chocolate) {
		Chocolate create = this.chocserv.createChocolate(chocolate);
		ResponseEntity<Chocolate> res = new ResponseEntity<Chocolate>(create, HttpStatus.CREATED);
		return res;
	}

	@GetMapping("/getAll")
	public List<Chocolate> getAllChocolates() {
		return this.chocserv.getAllChocolates();
	}

	@GetMapping("/get/{id}")
	public Chocolate getChocolate(@PathVariable Integer id) {
		Chocolate getChoc = this.chocserv.getChocolate(id);
		return getChoc;
	}

	@PutMapping("/replace/{id}")
	public ResponseEntity<Chocolate> replaceChocolate(@PathVariable Integer id, @RequestBody Chocolate newChocolate) {
		Chocolate replaceChoc = this.chocserv.replaceChocolate(id, newChocolate);
		ResponseEntity<Chocolate> res = new ResponseEntity<Chocolate>(replaceChoc, HttpStatus.ACCEPTED);
		return res;
	}

	@DeleteMapping("/remove/{id}")
	public ResponseEntity<Chocolate> removeChocolate(@PathVariable Integer id) {
		this.chocserv.removeChocolate(id);
		ResponseEntity<Chocolate> res = new ResponseEntity<Chocolate>(HttpStatus.NO_CONTENT);
		return res;
	}
}
