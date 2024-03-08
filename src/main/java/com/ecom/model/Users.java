package com.ecom.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String username;
	private String password;
	private Boolean primeUser;
	private String email;
	private Double mobileNumber;
	
	@OneToMany(mappedBy = "users")
	@JsonIgnore
	private List<Address> Address;
	
	
	@OneToMany(mappedBy = "users")
	@JsonIgnore
	private List<Orders> orders;
	
	@OneToMany(mappedBy = "users")
	@JsonIgnore
	private List<Payment> payments;
	
	
	
	
}
