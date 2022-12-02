package com.kotak.service.payment.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ProductJmsConfig {

    public static final String PRODUCT_QUEUE = "product_queue";
    public static final String PRODUCT_EXCHANGE_NAME = "PRODUCT_EXCHANGE";
    public static final String ROUTING_KEY = "product.#";

    @Primary
    @Bean
    Queue createProductQueue() {
        return new Queue(PRODUCT_QUEUE, false);
    }

    @Bean
    TopicExchange createProdcutExchange() {
        return new TopicExchange(PRODUCT_EXCHANGE_NAME);
    }

    @Bean
    Binding createProductBinding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);
    }

    @Bean
    SimpleMessageListenerContainer productContainer(ConnectionFactory connectionFactory) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        return container;
    }
}
