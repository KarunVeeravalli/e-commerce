package com.ecom.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String productName;
	private String productDescription;
	private Integer availableQuantity;
	private double price;
	private double mrpPrice;
	private String brand;
	

	@ManyToOne
	private Shipping shipping;
	
	@ManyToOne
	private Cart cart;
	
	@ManyToOne
	private Inventory inventory;
	
	@ManyToOne
	private Orders orders;
	
	@OneToOne
	private ReviewsAndRatings reviewsAndRatings;
	
	@OneToOne
	@JsonIgnore
	private Promotions promotions;
}
