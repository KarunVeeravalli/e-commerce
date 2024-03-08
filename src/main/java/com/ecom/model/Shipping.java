package com.ecom.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;


@Entity
@Setter
@Getter
public class Shipping {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@OneToOne
	private Address shippingAddress;
	private String shippingMethod;
	private String status;
	private LocalDate estimatedDeliveryDate;
	private String trackingNumber;
	private double shippingCost;
	private LocalDate shippingDate;
	private String deliveryConfirmed;
	
	@OneToMany(mappedBy = "shipping")
	private List<Product> product;
	
	@OneToOne
	private Orders orders;
	

	@ManyToOne
	@JoinColumn(name="users_id")
	private Users user;
	

}
