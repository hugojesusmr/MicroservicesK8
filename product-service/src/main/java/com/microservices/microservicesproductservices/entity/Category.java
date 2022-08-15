package com.microservices.microservicesproductservices.entity;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "tbl_category")
public class Category implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "El Nombre no debe estar vacio")
    private String name;
}
