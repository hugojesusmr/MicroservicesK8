package com.example.model;

import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name = "tbl_categories")
public class Category {

	private Long id;
	private String name;
}
