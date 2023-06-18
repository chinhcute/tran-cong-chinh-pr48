package org.example;

import mvc.confi.JPA_config;
import mvc.entity.OrderEntity;
import mvc.repository.OrderRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Main {
    static ApplicationContext context = new AnnotationConfigApplicationContext(JPA_config.class);
    static OrderRepository orderRepository = (OrderRepository) context.getBean("orderRepository");
    public static void main(String[] args) {
        List<OrderEntity> orderEntityList = orderRepository.findByCustomerNameContainingIgnoreCase("customer");

        System.out.println(orderEntityList);
    }
}