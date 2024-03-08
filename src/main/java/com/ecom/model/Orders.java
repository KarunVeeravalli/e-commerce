package com.ecom.model;

import java.time.LocalDateTime;
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
public class Orders {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@OneToMany(mappedBy = "orders")
	private List<Product> products;
	private double totalPrice;
	private LocalDateTime orderedAtTime;
	
	@OneToOne
	private Address address;
	

	@ManyToOne
	@JoinColumn(name="users_id")
	private Users users;
	
	@OneToOne
	private Shipping shipping;
	
	
	
}
