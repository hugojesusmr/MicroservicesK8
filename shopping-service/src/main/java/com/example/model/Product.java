package com.example.model;

import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name = "tbl_product")
public class Product {

	private Long id;
	private String name;
	private String description;
	private Double stock;
	private Double price;
	private String status;
	private Category category;
	
}
