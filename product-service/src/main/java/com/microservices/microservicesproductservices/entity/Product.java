package com.microservices.microservicesproductservices.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Product implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "El Nombre no debe estar vacio")
    private String name;
    @NotEmpty(message = "La descripcion no debe estar vacia")
    private String description;
    @Positive(message = "El Stock debe ser mayor que 0")
    private Double stock;
    @Positive(message = "El Precio debe ser mayor que 0")
    private Double price;
    private String status;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;
    @NotNull(message = "La Categoria no debe estar vacia")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    Category category; 
}
