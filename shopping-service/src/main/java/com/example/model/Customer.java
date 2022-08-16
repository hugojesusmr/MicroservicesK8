package com.example.model;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Table(name="tbl_customer")
public class Customer{

	private Long id;
	private String numberID;
	private String firstName;
	private String lastName;
	private String email;
	private Region region;
	private String state;
}
