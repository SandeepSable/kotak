package com.kotak.service.payment.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kotak.service.payment.model.Product;
import com.kotak.service.payment.rabbitmq.ProductJmsConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ProduceMessageService {

    private final RabbitTemplate rabbitTemplate;

    public ProduceMessageService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }


    public void employeeCreatedNotify(Product employee) {

        ObjectMapper objectMapper = new ObjectMapper();
        try {
           String empString =  objectMapper.writeValueAsString(employee);
            rabbitTemplate.convertAndSend(ProductJmsConfig.PRODUCT_EXCHANGE_NAME, "product.messages", empString);
        }
        catch (Exception ex) {
            log.error("Invalid product object. Parsing failed.");
        }
        log.info("Notified product creation on topic name:"+ ProductJmsConfig.PRODUCT_EXCHANGE_NAME);

    }


}
