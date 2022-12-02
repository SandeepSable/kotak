package com.kotak.service.payment.controller;

import com.kotak.service.payment.model.Product;
import com.kotak.service.payment.service.ProduceMessageService;
import com.kotak.service.payment.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController("/product")
public class ProductController {

	@Autowired
	ProduceMessageService produceMessageService;

	@Autowired
	ProductService productService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<Product> getProducts() {
		return productService.getAllProduct();
	}
	
	@PostMapping
	public ResponseEntity<Product> insertEmployee(@RequestBody Product product) {
		return ResponseEntity.status(201).body(productService.createProduct(product));
	}

	@Scheduled(cron = "* * * * * *")
	private void createProduct()
	{
		Random randomNum = new Random();
		Long id = randomNum.nextLong();
			Product product = new Product();
			product.setName("Product " + id);
			product.setId(id);
			product.setDescription("Product Description");
			product.setPrice(99.00);

	}
}
