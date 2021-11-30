package yafiet.net.orderservice.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
import org.springframework.web.bind.annotation.*;
import yafiet.net.orderservice.dto.OrderDto;
import yafiet.net.orderservice.model.Order;
import yafiet.net.orderservice.repository.OrderRepository;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
@Slf4j
public class OrderController {

    private final OrderRepository orderRepository;
    private final Resilience4JCircuitBreakerFactory circuitBreakerFactory;

    @PostMapping
    public String placeOrder(@RequestBody OrderDto orderDto) {
           Order order = new Order();
            order.setOrderLineItems(orderDto.getOrderLineItemsList());
            order.setOrderNumber(UUID.randomUUID().toString());

            orderRepository.save(order);
              return "Order Place Successfully";
    }

    @GetMapping
    List<Order> findAll(){
        return orderRepository.findAll();
    }
    private Boolean handleErrorCase() {
        return false;
    }
}
