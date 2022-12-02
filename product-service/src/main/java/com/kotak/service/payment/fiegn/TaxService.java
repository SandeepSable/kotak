/*
package com.kotak.services.loan.fiegn;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

//@FeignClient(name="TAX-SERVICE")
public interface TaxService {

    @GetMapping("/tax/data")
    public String getBookData();

    @GetMapping("/tax/{id}")
    public Tax getBookById(@PathVariable Integer id);

    @GetMapping("/tax/all")
    public List<Tax> getAllBooks();

    @GetMapping("/tax/entity")
    public ResponseEntity<String> getEntityData();
}*/
