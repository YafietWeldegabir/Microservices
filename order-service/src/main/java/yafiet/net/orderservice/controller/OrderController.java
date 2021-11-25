package yafiet.net.orderservice.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yafiet.net.orderservice.dto.OrderDto;
import yafiet.net.orderservice.model.Order;
import yafiet.net.orderservice.repository.OrderRepository;

import java.util.UUID;
import java.util.concurrent.ExecutorService;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
@Slf4j
public class OrderController {

    private final OrderRepository orderRepository;

    @PostMapping
    public String placeOrder(@RequestBody OrderDto orderDto) {
           Order order = new Order();
            order.setOrderLineItems(orderDto.getOrderLineItemsList());
            order.setOrderNumber(UUID.randomUUID().toString());

            orderRepository.save(order);
            log.info("Sending Order Details with Order Id {} to Notification Service", order.getId());
             return "Order Place Successfully";
    }

    private Boolean handleErrorCase() {
        return false;
    }
}
