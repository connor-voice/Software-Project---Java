package com.bae.febe.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Chocolate {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column
	private String name;

	@Column
	String brand;

	@Column
	private Double price;

	@Column
	private Double size;
	a

	@Column
	private Integer quantity;

	public Chocolate(Integer id, String name, String brand, Double price, Double size, Integer quantity) {
		super();
		this.id = id;
		this.name = name;
		this.brand = brand;
		this.price = price;
		this.size = size;
		this.quantity = quantity;
	}

	public Chocolate(String name, String brand, Double price, Double size, Integer quantity) {
		super();
		this.name = name;
		this.brand = brand;
		this.price = price;
		this.size = size;
		this.quantity = quantity;
	}

	public Chocolate() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getSize() {
		return size;
	}

	public void setSize(Double size) {
		this.size = size;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Chocolate [id=" + id + ", name=" + name + ", brand=" + brand + ", price=" + price + ", size=" + size
				+ ", quantity=" + quantity + "]";
	}

}
