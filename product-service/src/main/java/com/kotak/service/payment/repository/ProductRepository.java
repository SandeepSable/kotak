package com.kotak.service.payment.repository;

import com.kotak.service.payment.model.Product;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}