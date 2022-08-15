package com.example.model;

import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name="tbl_regions")
public class Region {
	
	private String name;
}
