package com.ecom.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;


@Entity
@Setter
@Getter
public class Payment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private Double amount;
	private Boolean paymentStatus;
	
	@OneToOne
	private Orders order;
	private LocalDateTime paymentTime;
	private String paymentType;
	
	

	@ManyToOne
	@JoinColumn(name="users_id")
	private Users users;
	
	
}
