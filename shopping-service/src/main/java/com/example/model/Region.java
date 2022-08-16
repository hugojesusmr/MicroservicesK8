package com.example.model;

import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name="tbl_region")
public class Region {
	
	private String name;
}
