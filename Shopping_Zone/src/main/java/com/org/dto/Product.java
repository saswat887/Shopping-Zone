package com.org.dto;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private long price;
	private String category;
	private String description;
	private int stockLeft;
	private int stockSold;
	@ManyToOne(cascade = CascadeType.ALL )
	@JoinColumn
	private Seller seller;
	@OneToOne(mappedBy = "product")
	private Item item;
	
}
