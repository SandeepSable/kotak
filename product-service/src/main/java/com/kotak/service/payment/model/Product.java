package com.kotak.service.payment.model;

import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "product")
@Data
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column
	private String name;

	private String description;

	@Column
	private double price;

}