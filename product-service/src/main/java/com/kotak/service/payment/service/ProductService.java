package com.kotak.service.payment.service;

import com.kotak.service.payment.model.Product;
import com.kotak.service.payment.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	@Autowired
	ProduceMessageService messageService;

	public List<Product> getAllProduct() {
		return productRepository.findAll();
	}

	public Product createProduct(Product product) {
		Product createdProduct = productRepository.save(product);
		messageService.employeeCreatedNotify(createdProduct);
		return createdProduct;
	}

}