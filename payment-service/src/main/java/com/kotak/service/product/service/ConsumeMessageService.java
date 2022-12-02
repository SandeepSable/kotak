package com.kotak.service.product.service;

import com.kotak.service.product.model.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ConsumeMessageService {

    public void consumeMessage(String employeeString) {
        log.info("Message received.");
        ObjectMapper objectMapper = new ObjectMapper();
        Employee employee = null;
        try {
            employee = objectMapper.readValue(employeeString, Employee.class);
        } catch (JsonProcessingException e) {
            log.error("Unable to parse MQ response for employee.");
            throw new RuntimeException(e);
        }
        log.info("Employee Created: " + employee.getEmpName());
    }
}
