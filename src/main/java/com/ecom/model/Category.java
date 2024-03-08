package com.ecom.model;

import java.util.List;

import com.ecom.enumType.CategoryType;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private CategoryType categoryType;
	

	@ManyToOne
	private Category mainCategory;

	@OneToMany(mappedBy = "mainCategory")
	private List<Category> subCategory;

	@OneToOne
	@JsonIgnore
	private Users users;
}
